package br.com.nao.ui.web.application.pl;

import java.io.Serializable;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthenticationPL implements PhaseListener, Serializable {

	private static final long serialVersionUID = -7531572949642800804L;

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		

	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {
		

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
