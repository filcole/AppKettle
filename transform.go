package transform

import (
	"crypto/aes"
	"crypto/cipher"
	"fmt"
)

const (
	secret1 = "ay3$&dw*ndAD!9)<" // 'a'
	secret2 = "7e3*WwI(@Dczxcue" // 'b'
)

/*
//From java:
   SecretKeySpec sks = new SecretKeySpec(secret1.getBytes("ASCII"), "AES");
   Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
   IvParameterSpec ips = new IvParameterSpec(secret2.getBytes());
   cipher.init(Cipher.DECRYPT_MODE, sks, ips);
   byte res[] = cipher.doFinal(decb);
   String sres = new String(res);
   System.out.println("Result: \"" + sres + "\"");
*/
func Decrypt(ciphertext []byte) []byte {
	mod := len(ciphertext) % 16
	if mod != 0 {
		//	fmt.Printf("(Cipherlen %d bytes (%d))", len(ciphertext), mod)
		ciphertext = ciphertext[:len(ciphertext)-mod]
	}
	key := []byte(secret1)

	c, err := aes.NewCipher(key)
	if err != nil {
		fmt.Printf("newcipher(): %s\n", err)
	}
	iv := []byte(secret2)
	mode := cipher.NewCBCDecrypter(c, iv)
	res := make([]byte, len(ciphertext))
	mode.CryptBlocks(res, ciphertext)

	return res
}

func Encrypt(plaintext []byte) []byte {
	for len(plaintext)%16 != 0 {
		//fmt.Printf("(Plainlen %d bytes (%d))\n", len(plaintext), len(plaintext)%16)
		plaintext = append(plaintext, 0)
	}
	key := []byte(secret1)

	c, err := aes.NewCipher(key)
	if err != nil {
		fmt.Printf("newcipher(): %s\n", err)
	}
	iv := []byte(secret2)
	mode := cipher.NewCBCEncrypter(c, iv)
	res := make([]byte, len(plaintext))
	mode.CryptBlocks(res, plaintext)

	return res
}
