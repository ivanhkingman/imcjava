/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2013, Laboratório de Sistemas e Tecnologia Subaquática
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the names of IMC, LSTS, IMCJava nor the names of its 
 *       contributors may be used to endorse or promote products derived from 
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL LABORATORIO DE SISTEMAS E TECNOLOGIA SUBAQUATICA
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 *                                                                             $:
 */

// Source generated by IMCJava from IMC version 5.4.1-rc1
package pt.lsts.imc;

/**
 *  IMC Message Acoustic Range Reply (205)<br/>
 *  Acoustic range measure in response to a range command.<br/>
 */

public class AcousticRangeReply extends IMCMessage {

	public static final int ID_STATIC = 205;

	public enum STATUS {
		OK(0),
		NO_RESPONSE(1),
		ERROR(2);

		protected long value;

		public long value() {
			return value;
		}

		STATUS(long value) {
			this.value = value;
		}
	}

	public AcousticRangeReply() {
		super(ID_STATIC);
	}

	public AcousticRangeReply(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AcousticRangeReply(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static AcousticRangeReply create(Object... values) {
		AcousticRangeReply m = new AcousticRangeReply();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static AcousticRangeReply clone(IMCMessage msg) throws Exception {

		AcousticRangeReply m = new AcousticRangeReply();
		if (msg == null)
			return m;
		if(msg.definitions != m.definitions){
			msg = msg.cloneMessage();
			IMCUtil.updateMessage(msg, m.definitions);
		}
		else if (msg.getMgid()!=m.getMgid())
			throw new Exception("Argument "+msg.getAbbrev()+" is incompatible with message "+m.getAbbrev());

		m.getHeader().values.putAll(msg.getHeader().values);
		m.values.putAll(msg.values);
		return m;
	}

	public AcousticRangeReply(short address, STATUS status, float range) {
		super(ID_STATIC);
		setAddress(address);
		setStatus(status);
		setRange(range);
	}

	/**
	 *  @return Target Modem Address - uint8_t
	 */
	public short getAddress() {
		return (short) getInteger("address");
	}

	/**
	 *  Status indicating reply to range request.<br/>
	 *  @return Status (enumerated) - uint8_t
	 */
	public STATUS getStatus() {
		try {
			STATUS o = STATUS.valueOf(getMessageType().getFieldPossibleValues("status").get(getLong("status")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  @return Range (m) - fp32_t
	 */
	public double getRange() {
		return getDouble("range");
	}

	/**
	 *  @param address Target Modem Address
	 */
	public AcousticRangeReply setAddress(short address) {
		values.put("address", address);
		return this;
	}

	/**
	 *  @param status Status (enumerated)
	 */
	public AcousticRangeReply setStatus(STATUS status) {
		values.put("status", status.value());
		return this;
	}

	/**
	 *  @param status Status (as a String)
	 */
	public AcousticRangeReply setStatus(String status) {
		setValue("status", status);
		return this;
	}

	/**
	 *  @param status Status (integer value)
	 */
	public AcousticRangeReply setStatus(short status) {
		setValue("status", status);
		return this;
	}

	/**
	 *  @param range Range (m)
	 */
	public AcousticRangeReply setRange(double range) {
		values.put("range", range);
		return this;
	}

}
