# Mail service user manual

## How to create mail

For sending mail, mail service uses class CiMail from commons library. That class contains:

    private String from;  
    private String to;  
    private String subject;  
    private String template;  
    private List<MailData> data;
MailData class contains:

    private String key;  
	private String value;

Generated json for sending should look like this for example:

    {
      "data": [
        {
          "key": "string",
          "value": "string"
        }
      ],
      "from": "string",
      "subject": "string",
      "template": "string",
      "to": "string"
    }

## Sending mail

Mail is sent by simply calling post method to:

    http://MAIL-SERVICE/mail
With `CiMail` class as body. User **must be fully authenticated** for mail to be sent

