package idv.fc.quiz.playstrategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import idv.debug.Debug;
import idv.fc.model.dto.HolderDataDTO;
import idv.fc.quiz.playstrategy.filterimpl.CommonFilter;
import idv.fc.quiz.playstrategy.filterimpl.PeriodFilter;
import idv.fc.quiz.playstrategy.modimpl.DefaultMod;
import idv.fc.quiz.playstrategy.modimpl.ProficiencyMod;
import idv.fc.quiz.playstrategy.modimpl.RandomMod;
import idv.fc.quiz.playstrategy.modimpl.TimeMod;

@Component
public class QuizPlayStrategyContextFactory
		implements FactoryBean<QuizPlayStrategyContext<HolderDataDTO>> {
	public static final String PERIOD="period";

	@Autowired
	private PeriodFilter periodFilter;

	@Autowired
	private CommonFilter commonFilter;

	@Autowired
	private RandomMod randomMod;

	@Autowired
	private ProficiencyMod proficiencyMod;

	@Autowired
	private TimeMod timeMod;

	@Autowired
	private DefaultMod defaultMod;

	@Override
	public QuizPlayStrategyContext<HolderDataDTO> getObject() throws Exception {
		Map<String, QuizFilter<HolderDataDTO>> filters = new HashMap<>();
		filters.put(PERIOD, periodFilter);
		filters.put("common", commonFilter);

		Map<String, QuizMod<HolderDataDTO>> mods = new HashMap<>();
		mods.put("default", defaultMod);//default at least one
		mods.put("random", randomMod);
		mods.put("proficiency", proficiencyMod);
		mods.put("time", timeMod);

		return new QuizPlayStrategyContext<HolderDataDTO>(filters, mods);
	}

	@Override
	public Class<?> getObjectType() {
		return QuizPlayStrategyContext.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
