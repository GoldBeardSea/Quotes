# Quotes

This is a lab completed by [Kent](https://github.com/KKetter) and [Tim](https://github.com/GoldBeardSea).

## Contents

It is a command line interface operated by scanner. Clone down the repository. Open in intellij and run the application.
The execution takes in a filepath to your json file in order to grab the quotes. Preferably you would use the included
quote file in assets. Run a gradle init on the top level directory of the project. Open in intellij or your preferred IDE.

### Classes

APIQuoteGrabber grabs a quote from ron swanson and adds it to the recentquotes.json file.

App is our command line interface class.

GSONQuoteGrabber if the internet is unavailable or if user specifies quotes will grab using this class.

Quote is the class that constructs quote objects.

