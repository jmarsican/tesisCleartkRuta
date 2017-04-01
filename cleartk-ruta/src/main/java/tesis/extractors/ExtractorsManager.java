package tesis.extractors;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import scenario.ScenarioPackage;

public class ExtractorsManager {
	
	private Map<String, PhraseExtractor> extractorsMap = new HashMap<String, PhraseExtractor>();
	
	public ExtractorsManager() {
		PhraseExtractor extractor;
		
		extractor = new DirectObjectExtractor(ScenarioPackage.GENERAL_SCENARIO__RESPONSE);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
		extractor = new NominalSubjectExtractor(ScenarioPackage.GENERAL_SCENARIO__RESPONSE);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
		extractor = new NominalSubjectPassiveExtractor(ScenarioPackage.GENERAL_SCENARIO__STIMULUS);
		extractorsMap.put(extractor.getEdgeRelationShortName(), extractor);
		
	}	
	
	public PhraseExtractor getExtractor(String relationShortName){
		return extractorsMap.get(relationShortName);
	}
	
	public Collection<PhraseExtractor> getExtractors() {
		return extractorsMap.values();
	}
}
