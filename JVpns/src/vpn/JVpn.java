package vpn;

import java.io.IOException;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinRas.RASENTRY;
import com.sun.jna.win32.StdCallLibrary;

public class JVpn {

	public interface eDll extends StdCallLibrary {
		eDll INSTANCE2 = (eDll) Native.loadLibrary("eDll", eDll.class);

		// 0 Ê§°Ü 1 ³É¹¦

		int createVpn(String name, String uname, String pwd, String ip, int type);

		int AddConnection(String strNewEntryName, String strNewPhoneNumber,
				String strNewCallbackNumber, String strNewUsername,
				String strNewPassword, String strNewDomain);

		int close(int hRasConn);

		int getRasCode();

		String getYzm();

		void dialog(int msg);

		int RasSetEntryPropertiesA(String lpszPhonebook, String lpszEntry,
				RASENTRY lpRasEntry, int dwEntryInfoSize, int lpbDeviceInfo,
				int wDeviceInfoSize);

		void RtlMoveMemory(char[] Destination, String Source, int lenght);

	}

	public interface dd extends StdCallLibrary {
		dd INSTANCE2 = (dd) Native.loadLibrary(dd.class);

		int RtlMoveMemory(char[] Destination, String Source, int lenght);
	}

}
