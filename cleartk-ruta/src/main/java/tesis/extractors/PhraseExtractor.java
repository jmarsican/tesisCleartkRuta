package tesis.extractors;

import java.util.stream.Stream;

import org.apache.log4j.Logger;

import simplenlg.framework.NLGFactory;
import simplenlg.framework.PhraseElement;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public abstract class PhraseExtractor {

	protected static final IndexedWord EMPTY_INDEXED_WORD = new IndexedWord("",0,0);

	protected NLGFactory mFactory;
	
	public PhraseElement assemble(SemanticGraph graph, SemanticGraphEdge edge) {
		Logger logger = Logger.getLogger(this.getClass());
		logger.debug(String.format("Assemble '%s' relation.", this.getEdgeRelationShortName()));
		return doAssemble(graph, edge);
	}
	
	protected abstract PhraseElement doAssemble(SemanticGraph graph, SemanticGraphEdge edge);

	public abstract String getEdgeRelationShortName();
	
	private Stream<SemanticGraphEdge> getOutEdgesSorted(SemanticGraph graph, IndexedWord node, String relationShortName){
		return graph.getOutEdgesSorted(node).stream()
				.filter(e -> relationShortName.equals(e.getRelation().getShortName()));
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
}
