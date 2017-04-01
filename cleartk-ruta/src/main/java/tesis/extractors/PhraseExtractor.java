package tesis.extractors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import scenario.Phrase;
import scenario.ScenarioFactory;
import scenario.impl.GeneralScenarioImpl;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import simplenlg.realiser.english.Realiser;
import tesis.clear_tk.XMIReaderTest;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;

public abstract class PhraseExtractor {
	protected static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord("",0,0);
    protected String RELATION_SHORT_NAME;
	
	protected int scenarioSection;
	protected NLGFactory mFactory;
	protected Realiser realizer;
	
	public PhraseExtractor(int section) {
		scenarioSection = section;
		mFactory = new NLGFactory();
		realizer = new Realiser();
	}
	
	protected abstract PhraseElement doAssemble(SemanticGraph graph, SemanticGraphEdge edge);

	public abstract String getEdgeRelationShortName();
	
	private Stream<SemanticGraphEdge> getOutEdgesSorted(SemanticGraph graph, IndexedWord node, String relationShortName){
		return graph.getOutEdgesSorted(node).stream()
				.filter(e -> relationShortName.equals(e.getRelation().getShortName()));
	}
	
	protected SemanticGraph getSemanticGraph(Annotation annotation) {
		    CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
		    return sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
	}
	
	protected IndexedWord getDependent(SemanticGraph graph, IndexedWord node, String relationShortName) {
		return getOutEdgesSorted(graph, node, relationShortName).findFirst()
				.map(e -> e.getDependent())
				.orElse(EMPTY_INDEXED_WORD);
	}
	
	protected void addCompounds(SemanticGraph graph, IndexedWord node, PhraseElement phrase) {
		PhraseElement modifier = mFactory.createNounPhrase();
		getOutEdgesSorted(graph, node, "compound")
			.forEach(edge -> modifier.addComplement(edge.getDependent().originalText()));
		phrase.addPreModifier(modifier);
	}
	
	public void extract(Annotation annotation, GeneralScenarioImpl scenario) {
		SemanticGraph graph = getSemanticGraph(annotation);
		List<SemanticGraphEdge> edges = graph.edgeListSorted();

		// Filtering edges
		List<SemanticGraphEdge> filteredEdges = edges.stream().filter(
				edge -> (edge.getRelation().getShortName()).equals(getEdgeRelationShortName()))
				.collect(Collectors.toList());

		filteredEdges.forEach(filteredEdge -> {
			PhraseElement phraseElement = doAssemble(graph, filteredEdge);
			String text = realizer.realise(phraseElement).toString();		
			int begin = annotation.get(CoreAnnotations.BeginIndexAnnotation.class);
			int end = annotation.get(CoreAnnotations.EndIndexAnnotation.class);
			
			Phrase phrase = ScenarioFactory.eINSTANCE.createPhrase();
			phrase.setBegin(begin);
			phrase.setEnd(end);
			phrase.setValue(text);
			Logger.getLogger(XMIReaderTest.class).info(text);
			((EList<Phrase>)scenario.eGet(scenarioSection, true, true)).add(phrase);
		});
	}
}
