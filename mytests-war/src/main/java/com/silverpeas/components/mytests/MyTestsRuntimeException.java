package com.silverpeas.components.mytests;

import com.stratelia.webactiv.util.exception.SilverpeasRuntimeException;

public class MyTestsRuntimeException extends SilverpeasRuntimeException{

	private static final long serialVersionUID = 5073180625893555293L;

	public MyTestsRuntimeException(String callingClass, int errorLevel,
			String message) {
		super(callingClass, errorLevel, message);
	}

	public MyTestsRuntimeException(String callingClass, int errorLevel,
			String message, String extraParams) {
		super(callingClass, errorLevel, message, extraParams);
	}

	public MyTestsRuntimeException(String callingClass, int errorLevel,
			String message, Exception nested) {
		super(callingClass, errorLevel, message, nested);
	}

	public MyTestsRuntimeException(String callingClass, int errorLevel,
			String message, String extraParams, Exception nested) {
		super(callingClass, errorLevel, message, extraParams, nested);
	}

	@Override
	public String getModule() {
		return "mytests";
	}

}
