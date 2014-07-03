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
 *  IMC Message Remote Sensor Info (601)<br/>
 *  Whenever the CUCS receives a message from one of the existing sensors (through SMS, ZigBee, Acoustic Comms, ...) it disseminates that info recurring to this message.<br/>
 */

public class RemoteSensorInfo extends IMCMessage {

	public static final int ID_STATIC = 601;

	public RemoteSensorInfo() {
		super(ID_STATIC);
	}

	public RemoteSensorInfo(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RemoteSensorInfo(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static RemoteSensorInfo create(Object... values) {
		RemoteSensorInfo m = new RemoteSensorInfo();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static RemoteSensorInfo clone(IMCMessage msg) throws Exception {

		RemoteSensorInfo m = new RemoteSensorInfo();
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

	public RemoteSensorInfo(String id, String sensor_class, double lat, double lon, float alt, float heading, String data) {
		super(ID_STATIC);
		if (id != null)
			setId(id);
		if (sensor_class != null)
			setSensorClass(sensor_class);
		setLat(lat);
		setLon(lon);
		setAlt(alt);
		setHeading(heading);
		if (data != null)
			setData(data);
	}

	/**
	 *  @return Id - plaintext
	 */
	public String getId() {
		return getString("id");
	}

	/**
	 *  @return Class - plaintext
	 */
	public String getSensorClass() {
		return getString("sensor_class");
	}

	/**
	 *  @return Latitude (rad) - fp64_t
	 */
	public double getLat() {
		return getDouble("lat");
	}

	/**
	 *  @return Longitude (rad) - fp64_t
	 */
	public double getLon() {
		return getDouble("lon");
	}

	/**
	 *  @return Altitude (m) - fp32_t
	 */
	public double getAlt() {
		return getDouble("alt");
	}

	/**
	 *  @return Heading (rad) - fp32_t
	 */
	public double getHeading() {
		return getDouble("heading");
	}

	/**
	 *  @return Custom Data (tuplelist) - plaintext
	 */
	public java.util.LinkedHashMap<String, String> getData() {
		return getTupleList("data");
	}

	/**
	 *  @param id Id
	 */
	public RemoteSensorInfo setId(String id) {
		values.put("id", id);
		return this;
	}

	/**
	 *  @param sensor_class Class
	 */
	public RemoteSensorInfo setSensorClass(String sensor_class) {
		values.put("sensor_class", sensor_class);
		return this;
	}

	/**
	 *  @param lat Latitude (rad)
	 */
	public RemoteSensorInfo setLat(double lat) {
		values.put("lat", lat);
		return this;
	}

	/**
	 *  @param lon Longitude (rad)
	 */
	public RemoteSensorInfo setLon(double lon) {
		values.put("lon", lon);
		return this;
	}

	/**
	 *  @param alt Altitude (m)
	 */
	public RemoteSensorInfo setAlt(double alt) {
		values.put("alt", alt);
		return this;
	}

	/**
	 *  @param heading Heading (rad)
	 */
	public RemoteSensorInfo setHeading(double heading) {
		values.put("heading", heading);
		return this;
	}

	/**
	 *  @param data Custom Data (tuplelist)
	 */
	public RemoteSensorInfo setData(java.util.LinkedHashMap<String, ?> data) {
		String val = encodeTupleList(data);
		values.put("data", val);
		return this;
	}

	public RemoteSensorInfo setData(String data) {
		values.put("data", data);
		return this;
	}

}
