/**
 *                            License
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS  
 * CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). 
 * THE WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW.  
 * ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS LICENSE OR  
 * COPYRIGHT LAW IS PROHIBITED.
 * 
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND  
 * AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE EXTENT THIS LICENSE  
 * MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED 
 * HERE IN CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 * 
 */
package l1j.server.server.serverpackets;

import l1j.server.server.Opcodes;

// Referenced classes of package l1j.server.server.serverpackets:
// ServerBasePacket

public class S_CharSynAck extends ServerBasePacket {

	private static final String S_CHARSYNACK = "[S] S_CharSynAck";

	private byte[] _byte = null;
	public static final int SYN = 0x0a;
	public static final int ACK = 0x40;

	public S_CharSynAck(int type) {
		buildPacket(type);
	}

	private void buildPacket(int type) {
		writeC(Opcodes.S_OPCODE_CHARSYNACK);
		writeC(type);   // SYN: 0x0a  ACK: 0x40
		if(type == 0x0a){
			writeC(0x02);
			writeC(0x00);
			writeC(0x00);
			writeC(0x00);
			writeC(0x08);
			writeC(0x00);
		} else{
			writeD(0x00000000);
			writeH(0x0000);
		}
		
	}
		

	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}

	@Override
	public String getType() {
		return S_CHARSYNACK;
	}
}
