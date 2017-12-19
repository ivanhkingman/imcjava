/*
 * Below is the copyright agreement for IMCJava.
 * 
 * Copyright (c) 2010-2016, Laboratório de Sistemas e Tecnologia Subaquática
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
 */
package pt.lsts.imc;


/**
 *  IMC Message SOI State (853)<br/>
 */

public class SoiState extends IMCMessage {

	public enum STATE {
		EXEC(1),
		IDLE(2),
		INACTIVE(3);

		protected long value;

		public long value() {
			return value;
		}

		STATE(long value) {
			this.value = value;
		}
	}

	public static final int ID_STATIC = 853;

	public SoiState() {
		super(ID_STATIC);
	}

	public SoiState(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SoiState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static SoiState create(Object... values) {
		SoiState m = new SoiState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static SoiState clone(IMCMessage msg) throws Exception {

		SoiState m = new SoiState();
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

	public SoiState(STATE state, int plan_id, short wpt_id, int settings_chk) {
		super(ID_STATIC);
		setState(state);
		setPlanId(plan_id);
		setWptId(wpt_id);
		setSettingsChk(settings_chk);
	}

	/**
	 *  @return State (enumerated) - uint8_t
	 */
	public STATE getState() {
		try {
			STATE o = STATE.valueOf(getMessageType().getFieldPossibleValues("state").get(getLong("state")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	public String getStateStr() {
		return getString("state");
	}

	public short getStateVal() {
		return (short) getInteger("state");
	}

	/**
	 *  @param state State (enumerated)
	 */
	public SoiState setState(STATE state) {
		values.put("state", state.value());
		return this;
	}

	/**
	 *  @param state State (as a String)
	 */
	public SoiState setStateStr(String state) {
		setValue("state", state);
		return this;
	}

	/**
	 *  @param state State (integer value)
	 */
	public SoiState setStateVal(short state) {
		setValue("state", state);
		return this;
	}

	/**
	 *  @return Plan Identifier - uint16_t
	 */
	public int getPlanId() {
		return getInteger("plan_id");
	}

	/**
	 *  @param plan_id Plan Identifier
	 */
	public SoiState setPlanId(int plan_id) {
		values.put("plan_id", plan_id);
		return this;
	}

	/**
	 *  @return Waypoint Identifier - uint8_t
	 */
	public short getWptId() {
		return (short) getInteger("wpt_id");
	}

	/**
	 *  @param wpt_id Waypoint Identifier
	 */
	public SoiState setWptId(short wpt_id) {
		values.put("wpt_id", wpt_id);
		return this;
	}

	/**
	 *  @return Settings Checksum - uint16_t
	 */
	public int getSettingsChk() {
		return getInteger("settings_chk");
	}

	/**
	 *  @param settings_chk Settings Checksum
	 */
	public SoiState setSettingsChk(int settings_chk) {
		values.put("settings_chk", settings_chk);
		return this;
	}

}