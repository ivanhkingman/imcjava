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
package pt.lsts.imc.def;

public enum CLoopsMask {

	NONE(0x00000000l),
	PATH(0x00000001l),
	TELEOPERATION(0x00000002l),
	ALTITUDE(0x00000004l),
	DEPTH(0x00000008l),
	ROLL(0x00000010l),
	PITCH(0x00000020l),
	YAW(0x00000040l),
	SPEED(0x00000080l),
	YAW_RATE(0x00000100l),
	VERTICAL_RATE(0x00000200l),
	TORQUE(0x00000400l),
	FORCE(0x00000800l),
	VELOCITY(0x00001000l),
	THROTTLE(0x00002000l),
	EXTERNAL(0x40000000l),
	NO_OVERRIDE(0x80000000l),
	ALL(0xFFFFFFFFl);

	protected long value;

	CLoopsMask(long value) {
		this.value = value;
	}

	public long value() {
		return value;
	}

	public static CLoopsMask valueOf(long value) throws IllegalArgumentException {
		for (CLoopsMask v : CLoopsMask.values()) {
			if (v.value == value) {
				return v;
			}
		}
		throw new IllegalArgumentException("Invalid value for CLoopsMask: "+value);
	}

}