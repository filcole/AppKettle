# AppKettle

This readme documents the AppKettle API as at 04/01/2017

## Login

```
http://ak.myappkettle.com/v1/Api/App/login?passWord=*password*&userName=*username*&lang=en
```

* *username* is the email address signed up with
* *password* is the setup

Note: The email and password are passed unencrypted over the internet.  JSON response returned in _unencrypted http_ is

```json
{
  "status": "200",
  "statusCode": "L0000",
  "msg": "_LOGIN_LOGIN_SUCCESSFULLY_",
  "data": {
    "id": "*snip*",        /* Integer ID number (of user?  of kettle?)
    "birthDay": null,
    "firstName": "Joe",    
    "middleName": null,
    "givenName": "Bloggs",
    "headImg": null,
    "lastLoginTime": "1483830657",            
    "lastLoginIp": "11.12.34.56",            /* IP address of last login */         
    "timeOut": "1482431802",
    "loginTimes": "23",                         /* Number of times logged into appkettle via this API */
    "userName": "joe.bloggs@company.com",        /* Email address igned up with using the app */
    "account": "Bloggs",
    "passWordEnCode": "*snip*",    /* Hashed password ??? */
    "passCode": null,
    "signupDate": "1491244613",     /* sign up date */
    "mobile": null,
    "status": "1",
    "activation": "1",
    "activationCode": "2a740c7a2d828a1868df055366e0f272",  /* activation code */
    "sendEmailDate": "2017-01-02 03:36:14",               /* date activation email sent! */
    "sendEmailStatus": "1",                                /* status of sending activation email? */
    "countryId": null,
    "token": "2d2fe1fc6c75fc5f88ff703ada81f81f",            /* security token - different upon each login */
    "temperatureUnit": "℃",                                
    "volumeUnit": "ml",
    "autoLoginOutTime": "10",
    "temperatureValue": "100",
    "heatTime": "1",
    "heatSwitch": "1",
    "cupValue": "250",
    "brewDelayTime": "0",
    "userId": "123"                              /* Internal? User ID, integer number */
  }
}
```

## GetMachineScheduleInfo

```
http://ak.myappkettle.com/v1/Api/App/getMachineScheduleInfo?lang=en&serialNumber=*serialnumber* 
```

* *lang* is en (maybe others are supported by untested)
* *serialNumber* is the serial number, perhaps obtained by the app when Pairing with the kettle

JSON response:

```json
{
  "status": "400",
  "statusCode": "MACERR0002",
  "msg": "Schedule info not updated, please try again",
  "data": ""
}
```

## getUserFavouritesList

```
GET /v1/Api/App/getUserFavouritesList?userId=*userId*&token=*token*
```

* *userId* previously returned by a login request
* login session *token* previously returned by a login request

JSON response:

```json
{
  "status": "200",
  "statusCode": "EU0002",
  "msg": "_FAVOURITES_GET_FAVOURITESLIST_SUCCESSFUL_",
  "data": [
    {
      "id": "512",
      "lastTime": "1483832123",
      "appId": "",
      "userId": "871",
      "type": "1",
      "name": "SmoothTea",
      "temperatureUnit": "℃",
      "temperature": "98",
      "brewTimer": "2",
      "status": "1",
      "default": "0",
      "favouritesSwitch": "1"
    }
  ]
}
```

## getScheduleInfo 

```
GET /v1/Api/App/getScheduleInfo?macAddress=*serialNumber*&serialNumber=*serialNumber*&userId=*userId*&SSID=AK_House&token=2d2fe1fc6c75fc5f88ff703ada81f81f&lang=en
```

* *serialNumber* previously returned by a login request
* *userId* previously returned by a login request
* *SSID* from when setup in the App
* login session *token* previously returned by a login request

JSON response:

```json
TBC
```

## List of other URLs (as of yet undocumented)

* https://ak.myappkettle.com/v3/api/app/addEnergyRecord
* https://ak.myappkettle.com/v3/api/app/addifttt
* https://ak.myappkettle.com/v3/api/app/addMachineInfo
* https://ak.myappkettle.com/v3/api/app/addScheduleInfo
* https://ak.myappkettle.com/v3/api/app/addUserFavourites
* https://ak.myappkettle.com/v3/api/app/bindingTripartite
* https://ak.myappkettle.com/v3/api/app/changePassWordByEmail
* https://ak.myappkettle.com/v3/api/app/checkVersion/os_type/android
* https://ak.myappkettle.com/v3/api/app/delEnergyRecord
* https://ak.myappkettle.com/v3/api/app/delUserFavourites
* https://ak.myappkettle.com/v3/api/app/editUserInfo
* https://ak.myappkettle.com/v3/api/app/forgotPassWord
* https://ak.myappkettle.com/v3/api/app/getEnergyRecord
* https://ak.myappkettle.com/v3/api/app/getMachineInfo
* https://ak.myappkettle.com/v3/api/app/getMachineScheduleInfo
* https://ak.myappkettle.com/v3/api/app/getMachineUserList
* https://ak.myappkettle.com/v3/api/app/getScheduleInfo
* https://ak.myappkettle.com/v3/api/app/getUserFavouritesList
* https://ak.myappkettle.com/v3/api/app/getUserMachineList
* https://ak.myappkettle.com/v3/api/app/login
* https://ak.myappkettle.com/v3/api/app/loginTripartite
* https://ak.myappkettle.com/v3/api/app/logout
* https://ak.myappkettle.com/v3/api/app/registerTripartite
* https://ak.myappkettle.com/v3/api/app/sendAccountActivationEmail
* https://ak.myappkettle.com/v3/api/app/setMachineInfo
* https://ak.myappkettle.com/v3/api/app/setUserMachineBinding
* https://ak.myappkettle.com/v3/api/app/setUserMachineCloudIp
* https://ak.myappkettle.com/v3/api/app/setUserMachineUnBinding
* https://ak.myappkettle.com/v3/api/app/signup
* https://ak.myappkettle.com/v3/api/app/unbundlingTripartite
* https://ak.myappkettle.com/v3/api/app/updateUserFavourites

## IoT CLoud

The Connectivity between kettle and the "cloud" seems to be provided by the "jingxuncloud".
The app establishes a connection to query.jingxuncloud.com:6001.
The traffic is AES encrypted, but jingxuncloud ships the secrets with the app and are available within the apk file.
The traffic may be captured with tcpdump 

tcpdump -s1600 -w/tmp/kettle.tcp port 6001

An example decryption implementation is implemented in the class Jingxuncloud in this repository

Example:

Message: "{"app_cmd":"101","list":["GD0-12900-892c"]}"

Response: "{"wifi_cmd":"101","list":["GD0-12900-892c"],"serverip":["52.29.217.226"]}"


## Dissection of the protocol:
1) Tcpdump the app

* Traffic to ak.myappkettle.com and query.jingxuncloud.com
### ak.myappkettle.com
* Install apk on emulator
* Install certificate
Proxy ak.myappkettle.com with own certificate
Read traffic
Traffic not interesting.. (userprofile, babybottle etc)
Speaks to query.jingxuncloud.com
Courtesy of Googling: provider of IoT Hardware (oh!)
Traffic on Port 6001/6002
Created Proxy (golang httputil.ReverseProxy) for both ports
Found plain http - yeah ;)
message/response not cleartext
Apktool & grep found two “random” variables in the code and string “aes/cbc/nopadding” right next to it ;)
Decoding using the random variables as IV & key for aes transforms message & responses into plaintext
One of the responses included a “serverip”: `{"wifi_cmd":"101","list":["GD0-12900-892c"],"serverip":["52.29.217.226"]}`
Changed response on-the fly to serverip of a local address
Transmission now goes via port 6002
6002 does not appear to be http

6002 is obfuscated in heartbeat and non-heatbeat messages.
The non-heartbeat messages go through this conversion in AesUtils:

# this isn't AES at all, this is some other random xor mechanism ;(
.method private static a([B)Ljava/lang/String;
   .locals 6

   .prologue
   .line 87
   const-string v1, ""

   .line 88
   const/4 v0, 0x0

   move v5, v0

   move-object v0, v1

   move v1, v5
#v5=0, v0="",v1=0
   .line 89
   :goto_0
   array-length v2, p0
# v2= len(param1)
   if-lt v1, v2, :cond_0
# just uppercase and return. will this ever be called???
   .line 97
   invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

   move-result-object v0

   return-object v0

   .line 90
   :cond_0
# "normal" path:
   aget-byte v2, p0, v1 # I "think" this means v2 = p0[v1]

   and-int/lit16 v2, v2, 0xff

   invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

   move-result-object v2
# v2 is now toHexString(p0[v1])
   .line 91
   invoke-virtual {v2}, Ljava/lang/String;->length()I

   move-result v3

   const/4 v4, 0x1

   # if first byte is less or equal 0x0F goto cond_1
   if-ne v3, v4, :cond_1

   .line 92
   new-instance v3, Ljava/lang/StringBuilder;

   invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

   move-result-object v0

   invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

   const-string v0, "0"

   invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

   move-result-object v0

   invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

   move-result-object v0

   invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

   move-result-object v0

   .line 89
   :goto_1
   add-int/lit8 v1, v1, 0x1

   goto :goto_0

   .line 94
   :cond_1
   new-instance v3, Ljava/lang/StringBuilder;

   invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

   move-result-object v0

   invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

   invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

   move-result-object v0

   invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

   move-result-object v0

   goto :goto_1
.end method


(see here)

v1=""
v0=0
v5=0
v0=""
v1=0
v2=len(para0)
if  (v1 >= len(para0) ) {
return toUpper(v0)
}
v2 = p0[v1]
v2 = v2 & 0xFF
v2 = toHexString(v2)
v3 = len(v2)
v4 = 1
if len(v2) == 1 {
v3 = new Stringbuilder(v0)
v0="0"
v0 = v3.append("0")
v0 = v0.append(v2)
LABEL GOTO_1
v1++
GOTO GOTO_0
}
LABEL_COND 1
v3 = new StringBuilder(v0)
v0 = v3.append(v2)
v0 = v0.toString()
GOTO GOTO_1

Puzzling: this is what we receive:
2323383038308f557faa68e327b189481cf301029d3a76d6202545e5a5589eed3fd9a4675121f41a860e02f01509ef32266aea3c798d9103f28b6297eeea4a82481d6960796cb50d52a55a2b5e12f6e4c1b6945c59a0b105d5215cf9481efea069387dbb377377a5ccd5f2f25ede0a2c0a8858cef851de6b88f569d02ffe7969d1fbee90c6e82626

And from the android logcat:
09-06 13:38:22.957  3291  3605 E Decoder : Decoder---------1---decoded----str={"wifi_cmd":"201","imei":"GD0-12900-892c","SubDev":"00","data3":"aa001803000000000000001c360000c8000200005964022e0000db"}<C0><80><C0><80><C0><80><C0><80><C0><80><C0><80><C0>

The conversion is a  bit of a puzzle. Some piece is missing.

------------------

Oh no, it’s actually calling THIS:


.method public final a([B)[B
   .locals 4
   .annotation system Ldalvik/annotation/Throws;
       value = {
           Ljava/lang/Exception;
       }
   .end annotation

   .prologue
   .line 65
   :try_start_0
   iget-object v0, p0, Lcom/jingxun/jingxun/e/a;->a:Ljava/lang/String;

   const-string v1, "ASCII"

   invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

   move-result-object v0

   .line 66
   new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

   const-string v2, "AES"

   invoke-direct {v1, v0, v2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

   .line 67
   const-string v0, "AES/CBC/NoPadding"

   invoke-static {v0}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

   move-result-object v0

   .line 68
   new-instance v2, Ljavax/crypto/spec/IvParameterSpec;

   iget-object v3, p0, Lcom/jingxun/jingxun/e/a;->b:Ljava/lang/String;

   invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

   move-result-object v3

   invoke-direct {v2, v3}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

   .line 69
   const/4 v3, 0x2

   invoke-virtual {v0, v3, v1, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

   .line 74
   invoke-virtual {v0, p1}, Ljavax/crypto/Cipher;->doFinal([B)[B
   :try_end_0
   .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

   move-result-object v0

   .line 78
   :goto_0
   return-object v0

   :catch_0
   move-exception v0

   const/4 v0, 0x0

   goto :goto_0
.end method



Gives me the desired result:

{"wifi_cmd":"201","imei":"GD0-12900-892c","SubDev":"00","data3":"aa00180300000000000000f1360000c8000400005764022e000006"}', Uid=201}

Note the number in red - that’s the temperature
