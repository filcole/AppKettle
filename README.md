# AppKettle

This readme documents the AppKettle API as at 04/01/2017

Login

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
