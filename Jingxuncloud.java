/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.conradwood;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author cnw
 */
public class Jingxuncloud {

    public final static String secret1 = "ay3$&dw*ndAD!9)<"; // 'a'
    public final static String secret2 = "7e3*WwI(@Dczxcue"; // 'b'

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        decode(getPacket1());
        decode(getPacket2());

    }

    public static String decode(int deci[]) throws Exception {
        byte decb[] = new byte[deci.length];
        for (int i = 0; i < deci.length; i++) {
            decb[i] = (byte) deci[i]; // lack of java unsigned bytes is annoying!
        }

        SecretKeySpec sks = new SecretKeySpec(secret1.getBytes("ASCII"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        IvParameterSpec ips = new IvParameterSpec(secret2.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, sks, ips);
        byte res[] = cipher.doFinal(decb);
        String sres = new String(res);
        System.out.println("Result: \"" + sres + "\"");
        return sres;
    }

    // from tcpdump -> message
    public static int[] getPacket1() {
        int deci[] = { /* Packet 4 */
            0x13, 0xbe,
            0x40, 0xf1, 0x06, 0x57, 0xb5, 0xfc, 0x78, 0x88,
            0xb1, 0xf5, 0x1c, 0xf6, 0xdb, 0x54, 0x0c, 0xe2,
            0x69, 0xe7, 0xee, 0x00, 0x92, 0x1b, 0x55, 0x43,
            0xa6, 0xe6, 0xa3, 0xee, 0xaf, 0xc3, 0x8c, 0x97,
            0x90, 0xe2, 0xad, 0x0c, 0x7e, 0x4c, 0x9d, 0xd2,
            0xc6, 0xc9, 0x54, 0xa9, 0xe3, 0x59};
        return deci;
    }

    // from tcpdump -> response
    public static int[] getPacket2() {
        int deci[] = {0x91,
            0x5a, 0x30, 0x0c, 0x39, 0xb6, 0x98, 0xfc, 0x82,
            0xad, 0xbe, 0xef, 0xd3, 0x8f, 0x10, 0x73, 0xd5,
            0xa1, 0xce, 0xfd, 0xfb, 0xb3, 0xf7, 0xe2, 0xf6,
            0x91, 0xcf, 0x72, 0x09, 0x3f, 0x62, 0xc4, 0x7f,
            0x03, 0xe5, 0x94, 0x77, 0x72, 0xed, 0xa9, 0x9a,
            0xb2, 0x5c, 0x69, 0x4e, 0x13, 0x19, 0xcd, 0xe1,
            0x7a, 0xae, 0x74, 0x9f, 0xde, 0x76, 0xb1, 0x3d,
            0x4a, 0xdd, 0xcb, 0x21, 0xab, 0xd3, 0x29, 0xb7,
            0x7b, 0x47, 0xbc, 0x6a, 0xca, 0xce, 0x24, 0xe8,
            0xce, 0x9c, 0x72, 0x45, 0xea, 0x13, 0xf7};
        return deci;
    }

}
