


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

 * Found Traffic to ak.myappkettle.com and query.jingxuncloud.com
### Analysis of ak.myappkettle.com
 * Installed apk on emulator
 * Installed ca certificate
 * Proxy ak.myappkettle.com with own certificate
 * Read traffic
 * Traffic is not very interesting.. (for example: userprofile, babybottle etc)
### Analysis of query.jingxuncloud.com
 * Courtesy of Googling: provider of IoT Hardware (oh!) 
 * Traffic on Ports 6001/6002
 * Created Proxy (golang httputil.ReverseProxy) for both ports
 * Found plain http - yeah ;)
 * message/response bodies are not cleartext
 * Apktool & grep found two “random” variables in the code and string a "aes/cbc/nopadding” right next to it ;) 
 * Decoding using the random variables as IV & key for aes transforms message & responses into plaintext
 * One of the responses included a “serverip”:
   `{"wifi_cmd":"101","list":["GD0-12900-892c"],"serverip":["52.29.217.226"]}`
  * Changed response on-the fly to serverip of a local address
* Transmission now goes via port 6002 6002
*  it does not appear to be http
* traffic on port 6002 is obfuscated in heartbeat and non-heatbeat messages.
* The non-heartbeat messages go through the same conversion in AesUtils: 

**and it gives me the desired result:**

    {"wifi_cmd":"201","imei":"GD0-12900-892c","SubDev":"00","data3":"aa00180300000000000000f1360000c8000400005764022e000006"}', Uid=201}

Note the number 57, that's the temperature (in hex, celsius)

Currently unknown:
* does the kettle accept such messages itself?
* Are they encoded the same way?
* Is there any authentication on the jingxuncloud at all? :)
