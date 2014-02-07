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

// Source generated by IMCJava from IMC version 5.4.x
package pt.lsts.imc;

/**
 *  IMC Message Vehicle State (500)<br/>
 *  This message summarizes the overall state of the vehicle. It can<br/>
 *  contains information regarding:<br/>
 *  - The overall operation mode.<br/>
 *  - Any error conditions.<br/>
 *  - Current maneuver execution.<br/>
 *  - Active control loops.<br/>
 */

public class VehicleState extends IMCMessage {

	public static final int ID_STATIC = 500;

	public static final long CL_NONE = 0x00000000;
	public static final long CL_PATH = 0x00000001;
	public static final long CL_TELEOPERATION = 0x00000002;
	public static final long CL_ALTITUDE = 0x00000004;
	public static final long CL_DEPTH = 0x00000008;
	public static final long CL_ROLL = 0x00000010;
	public static final long CL_PITCH = 0x00000020;
	public static final long CL_YAW = 0x00000040;
	public static final long CL_SPEED = 0x00000080;
	public static final long CL_YAW_RATE = 0x00000100;
	public static final long CL_VERTICAL_RATE = 0x00000200;
	public static final long CL_TORQUE = 0x00000400;
	public static final long CL_EXTERNAL = 0x40000000;
	public static final long CL_NO_OVERRIDE = 0x80000000;
	public static final long CL_ALL = 0xFFFFFFFF;

	public static final short VFLG_MANEUVER_DONE = 0x01;

	public enum OP_MODE {
		SERVICE(0),
		CALIBRATION(1),
		ERROR(2),
		MANEUVER(3),
		EXTERNAL(4),
		BOOT(5);

		protected long value;

		public long value() {
			return value;
		}

		OP_MODE(long value) {
			this.value = value;
		}
	}

	public VehicleState() {
		super(ID_STATIC);
	}

	public VehicleState(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static VehicleState create(Object... values) {
		VehicleState m = new VehicleState();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static VehicleState clone(IMCMessage msg) throws Exception {

		VehicleState m = new VehicleState();
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

	public VehicleState(OP_MODE op_mode, short error_count, String error_ents, int maneuver_type, double maneuver_stime, int maneuver_eta, long control_loops, short flags, String last_error, double last_error_time) {
		super(ID_STATIC);
		setOpMode(op_mode);
		setErrorCount(error_count);
		if (error_ents != null)
			setErrorEnts(error_ents);
		setManeuverType(maneuver_type);
		setManeuverStime(maneuver_stime);
		setManeuverEta(maneuver_eta);
		setControlLoops(control_loops);
		setFlags(flags);
		if (last_error != null)
			setLastError(last_error);
		setLastErrorTime(last_error_time);
	}

	/**
	 *  The overall operation mode.<br/>
	 *  @return Operation Mode (enumerated) - uint8_t
	 */
	public OP_MODE getOpMode() {
		try {
			OP_MODE o = OP_MODE.valueOf(getMessageType().getFieldPossibleValues("op_mode").get(getLong("op_mode")));
			return o;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 *  @return Errors -- Count - uint8_t
	 */
	public short getErrorCount() {
		return (short) getInteger("error_count");
	}

	/**
	 *  @return Errors -- Entities - plaintext
	 */
	public String getErrorEnts() {
		return getString("error_ents");
	}

	/**
	 *  @return Maneuver -- Type - uint16_t
	 */
	public int getManeuverType() {
		return getInteger("maneuver_type");
	}

	/**
	 *  @return Maneuver -- Start Time (s) - fp64_t
	 */
	public double getManeuverStime() {
		return getDouble("maneuver_stime");
	}

	/**
	 *  @return Maneuver -- ETA (s) - uint16_t
	 */
	public int getManeuverEta() {
		return getInteger("maneuver_eta");
	}

	/**
	 *  Enabled control loops.<br/>
	 *  @return Control Loops (bitfield) - uint32_t
	 */
	public long getControlLoops() {
		return getLong("control_loops");
	}

	/**
	 *  @return Flags (bitfield) - uint8_t
	 */
	public short getFlags() {
		return (short) getInteger("flags");
	}

	/**
	 *  @return Last Error -- Description - plaintext
	 */
	public String getLastError() {
		return getString("last_error");
	}

	/**
	 *  @return Last Error -- Time (s) - fp64_t
	 */
	public double getLastErrorTime() {
		return getDouble("last_error_time");
	}

	/**
	 *  @param op_mode Operation Mode (enumerated)
	 */
	public void setOpMode(OP_MODE op_mode) {
		values.put("op_mode", op_mode.value());
	}

	/**
	 *  @param op_mode Operation Mode (as a String)
	 */
	public void setOpMode(String op_mode) {
		setValue("op_mode", op_mode);
	}

	/**
	 *  @param op_mode Operation Mode (integer value)
	 */
	public void setOpMode(short op_mode) {
		setValue("op_mode", op_mode);
	}

	/**
	 *  @param error_count Errors -- Count
	 */
	public void setErrorCount(short error_count) {
		values.put("error_count", error_count);
	}

	/**
	 *  @param error_ents Errors -- Entities
	 */
	public void setErrorEnts(String error_ents) {
		values.put("error_ents", error_ents);
	}

	/**
	 *  @param maneuver_type Maneuver -- Type
	 */
	public void setManeuverType(int maneuver_type) {
		values.put("maneuver_type", maneuver_type);
	}

	/**
	 *  @param maneuver_stime Maneuver -- Start Time (s)
	 */
	public void setManeuverStime(double maneuver_stime) {
		values.put("maneuver_stime", maneuver_stime);
	}

	/**
	 *  @param maneuver_eta Maneuver -- ETA (s)
	 */
	public void setManeuverEta(int maneuver_eta) {
		values.put("maneuver_eta", maneuver_eta);
	}

	/**
	 *  @param control_loops Control Loops (bitfield)
	 */
	public void setControlLoops(long control_loops) {
		values.put("control_loops", control_loops);
	}

	/**
	 *  @param flags Flags (bitfield)
	 */
	public void setFlags(short flags) {
		values.put("flags", flags);
	}

	/**
	 *  @param last_error Last Error -- Description
	 */
	public void setLastError(String last_error) {
		values.put("last_error", last_error);
	}

	/**
	 *  @param last_error_time Last Error -- Time (s)
	 */
	public void setLastErrorTime(double last_error_time) {
		values.put("last_error_time", last_error_time);
	}

}
