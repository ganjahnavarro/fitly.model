package core.report;

import core.model.program.Program;

public class ProgramPurchaseSummary {

	private Program program;
	private Long count;
	
	public ProgramPurchaseSummary(Program program, Long count) {
		this.program = program;
		this.count = count;
	}

	public Program getProgram() {
		return program;
	}

	public Long getCount() {
		return count;
	}

}
