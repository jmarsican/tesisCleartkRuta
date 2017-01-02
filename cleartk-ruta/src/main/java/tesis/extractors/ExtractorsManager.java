package tesis.extractors;

import java.util.HashMap;
import java.util.Map;

import simplenlg.framework.NLGFactory;

public class ExtractorsManager {
	
	private Map<String, PhraseExtractor> extractorsMap = new HashMap<String, PhraseExtractor>();
	
	public ExtractorsManager(NLGFactory factory) {
		PhraseExtractor extractor;
		
		extractor = new DirectObjectExtractor(factory);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
		extractor = new NominalSubjectExtractor(factory);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
		extractor = new NominalSubjectPassiveExtractor(factory);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
		extractor = new NounModExtractor(factory);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
	}	
	
	public PhraseExtractor getExtractor(String relationShortName){
		return extractorsMap.get(relationShortName);
	}
}
