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

// Source generated by IMCJava from IMC version 5.3.x
package pt.up.fe.dceg.neptus.imc;

/**
 *  IMC Message Sonar Configuration (275)<br/>
 *  This message contains high-level runtime configuration<br/>
 *  parameters for Sonars.<br/>
 */

public class SonarConfig extends Payload {

	public static final int ID_STATIC = 275;

	public SonarConfig() {
		super(ID_STATIC);
	}

	public SonarConfig(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static SonarConfig create(Object... values) {
		SonarConfig m = new SonarConfig();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static SonarConfig clone(IMCMessage msg) throws Exception {

		SonarConfig m = new SonarConfig();
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

	public SonarConfig(long frequency, int min_range, int max_range) {
		super(ID_STATIC);
		setFrequency(frequency);
		setMinRange(min_range);
		setMaxRange(max_range);
	}

	/**
	 *  @return Frequency (hz) - uint32_t
	 */
	public long getFrequency() {
		return getLong("frequency");
	}

	/**
	 *  @return Minimum Range (m) - uint16_t
	 */
	public int getMinRange() {
		return getInteger("min_range");
	}

	/**
	 *  @return Maximum Range (m) - uint16_t
	 */
	public int getMaxRange() {
		return getInteger("max_range");
	}

	/**
	 *  @param frequency Frequency (hz)
	 */
	public void setFrequency(long frequency) {
		values.put("frequency", frequency);
	}

	/**
	 *  @param min_range Minimum Range (m)
	 */
	public void setMinRange(int min_range) {
		values.put("min_range", min_range);
	}

	/**
	 *  @param max_range Maximum Range (m)
	 */
	public void setMaxRange(int max_range) {
		values.put("max_range", max_range);
	}

}
