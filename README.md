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
