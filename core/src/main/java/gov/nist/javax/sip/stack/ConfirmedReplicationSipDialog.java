/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package gov.nist.javax.sip.stack;

import gov.nist.javax.sip.SipProviderImpl;
import gov.nist.javax.sip.message.SIPResponse;

/**
 * Extends the standard NIST SIP Stack Dialog so that it gets replicated every time there is a State change
 * 
 * @author jean.deruelle@gmail.com
 *
 */
public class ConfirmedReplicationSipDialog extends ConfirmedNoAppDataReplicationSipDialog {	
	
	private static final long serialVersionUID = -779892668482217624L;

	private Object appData;
	
	public ConfirmedReplicationSipDialog(SIPTransaction transaction) {
		super(transaction);
	}
	
	public ConfirmedReplicationSipDialog(SIPClientTransaction transaction, SIPResponse sipResponse) {
		super(transaction, sipResponse);
	}
	
    public ConfirmedReplicationSipDialog(SipProviderImpl sipProvider, SIPResponse sipResponse) {
		super(sipProvider, sipResponse);
	}	

	@Override
	public void setApplicationData(Object applicationData) {
		this.appData = applicationData;
		replicateState();
	}	
	
	@Override
	public Object getApplicationData() {
		return appData;
	}
}