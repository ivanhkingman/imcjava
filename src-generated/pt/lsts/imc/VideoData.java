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
 *  IMC Message Video Data (700)<br/>
 */

public class VideoData extends IMCMessage {

	public static final int ID_STATIC = 700;

	public VideoData() {
		super(ID_STATIC);
	}

	public VideoData(IMCMessage msg) {
		super(ID_STATIC);
		try{
			copyFrom(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VideoData(IMCDefinition defs) {
		super(defs, ID_STATIC);
	}

	public static VideoData create(Object... values) {
		VideoData m = new VideoData();
		for (int i = 0; i < values.length-1; i+= 2)
			m.setValue(values[i].toString(), values[i+1]);
		return m;
	}

	public static VideoData clone(IMCMessage msg) throws Exception {

		VideoData m = new VideoData();
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

	public VideoData(short id, int width, int height, int widthstep, short channels, short depth, short finaldata, byte[] data) {
		super(ID_STATIC);
		setId(id);
		setWidth(width);
		setHeight(height);
		setWidthstep(widthstep);
		setChannels(channels);
		setDepth(depth);
		setFinaldata(finaldata);
		if (data != null)
			setData(data);
	}

	/**
	 *  @return Identification Number - uint8_t
	 */
	public short getId() {
		return (short) getInteger("id");
	}

	/**
	 *  @return Width Size - uint16_t
	 */
	public int getWidth() {
		return getInteger("width");
	}

	/**
	 *  @return Height Size - uint16_t
	 */
	public int getHeight() {
		return getInteger("height");
	}

	/**
	 *  @return Width Step - uint16_t
	 */
	public int getWidthstep() {
		return getInteger("widthstep");
	}

	/**
	 *  @return Number of Channels - uint8_t
	 */
	public short getChannels() {
		return (short) getInteger("channels");
	}

	/**
	 *  @return Pixel Depth - uint8_t
	 */
	public short getDepth() {
		return (short) getInteger("depth");
	}

	/**
	 *  @return Final Data - uint8_t
	 */
	public short getFinaldata() {
		return (short) getInteger("finaldata");
	}

	/**
	 *  @return Data - rawdata
	 */
	public byte[] getData() {
		return getRawData("data");
	}

	/**
	 *  @param id Identification Number
	 */
	public VideoData setId(short id) {
		values.put("id", id);
		return this;
	}

	/**
	 *  @param width Width Size
	 */
	public VideoData setWidth(int width) {
		values.put("width", width);
		return this;
	}

	/**
	 *  @param height Height Size
	 */
	public VideoData setHeight(int height) {
		values.put("height", height);
		return this;
	}

	/**
	 *  @param widthstep Width Step
	 */
	public VideoData setWidthstep(int widthstep) {
		values.put("widthstep", widthstep);
		return this;
	}

	/**
	 *  @param channels Number of Channels
	 */
	public VideoData setChannels(short channels) {
		values.put("channels", channels);
		return this;
	}

	/**
	 *  @param depth Pixel Depth
	 */
	public VideoData setDepth(short depth) {
		values.put("depth", depth);
		return this;
	}

	/**
	 *  @param finaldata Final Data
	 */
	public VideoData setFinaldata(short finaldata) {
		values.put("finaldata", finaldata);
		return this;
	}

	/**
	 *  @param data Data
	 */
	public VideoData setData(byte[] data) {
		values.put("data", data);
		return this;
	}

}
