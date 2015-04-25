You probably know the business contacts community [XING](http://xing.com). All registered users can create a profile there, which can also be made publicly available. When playing with dine and searching for examples, I thought I'll show how to parse those public profiles into an invented XML schema.

The code is pretty straight forward, actually I'm just searching for the HTML tags containing the data via their CSS class names ( I used [Firebug](https://addons.mozilla.org/de/firefox/addon/1843), an excellent Firefox addon to find them ).

The code could be easily modified to traverse the network of public friends, but I won't show this here to prevent misuse.

# Code #

_Unfortunately googlecode's codehighlighting breaks when you use E4X syntax in JavaScript, nevertheless I hope you can read the code below. I already reported this bug and hope it will be fixed soon._

```
createStep({
	getUrl: function( ctx ) {
	
		var firstname = "PASTE FIRST NAME HERE";
		var lastname =  "PASTE LAST NAME HERE";
	
		return "https://www.xing.com/profile/"
					+ctx.encode( firstname )
					+"_"
					+ctx.encode( lastname );
	},
	
	run: function( ctx ) {		
		
		var xml = new XML( ctx.getResponse() );

		// if there's no name in the title, this is not a profile
		if ( String( xml..title ) == "XING" ) {
			print( "No profile found...");
			return;
		}

		// our output stub
		output = <profile>
                            <name>{String( xml..title ).replace(/XING - /, "")}</name>
                            <location/>	
                            <skills/>			
                            <jobhistory/>
                          </profile>;

		// what skills are offered?				 				 
		for each ( var skill in xml..div.(@["class"] == "profile-col-content")[1]..a.text() ) {
			output.skills.appendChild( <skill>{skill}</skill> );
		}		 
				 
		// location info		 
		output.location.@country	= xml..span.(@["id"] == "photobox-country").text();	

		output.location.appendChild(
				<city postalCode={xml..span.(@["id"] == "photobox-zipcode").a[0].text()}>{xml..span.(@["id"] == "photobox-city").a[0].text()}</city>
			);

		for each ( var job in xml..div.(@["class"] == "experience vevent vcard") ) {						

			var jobDesc =	<job>
                                          <occupation>{job..p.(@["class"] == "profile-work-descr")..a[0].text()}</occupation>
                                        </job>;
			
			// from when?
			var from = job..abbr.(@["class"] == "dtstart").text();
			
			if ( String(from) != "" )
				jobDesc.@from = from;
			
			// until when?							
			var until = job..abbr.(@["class"] == "dtend").text();
			
			if ( String( until ) != "" )
				jobDesc.@until = until;							
							
			// name of the company				
			var company = String( job..p.(@["class"] == "profile-work-descr org")..a[0] );
			
			if ( company != "undefined" )
				jobDesc.appendChild( <company>{company}</company> );					
							
			
			output.jobhistory.appendChild( jobDesc );
		} 

		print( output.toXMLString() );
	}
	
});
```


# Sample Output #

The name is left blank for obvious privacy reasons.

```
<profile>
  <name>...</name>
  <location country="Germany">
    <city postalCode="10178">Berlin</city>
  </location>
  <skills>
    <skill>Grafik</skill>
    <skill>Corporate Design</skill>
    <skill>Print</skill>
    <skill>Screendesign</skill>
    <skill>Typographie</skill>
    <skill>Video Compositing</skill>
    <skill>Clay modelling</skill>
  </skills>
  <jobhistory>
    <job from="Mar 2008" until="present">
      <occupation>Junior Designer</occupation>
    </job>
    <job from="Sep 2007" until="Feb 2008">
      <occupation>Screendesign</occupation>
      <company>Aimaq·Rapp·Stolle</company>
    </job>
    <job from="Apr 2007" until="May 2007">
      <occupation>Grafik &amp; Design</occupation>
      <company>Multipick Bonn</company>
    </job>
    <job from="Feb 2007" until="Apr 2007">
      <occupation>Kabelträger &amp; Postproduction</occupation>
      <company>Spectrafilm Bonn</company>
    </job>
    <job from="Jun 2006" until="Jan 2007">
      <occupation>Design Trainee</occupation>
      <company>liebe glaube hoffnung</company>
    </job>
    <job from="Jul 2003" until="Nov 2005">
      <occupation>Konzeption &amp; Design</occupation>
      <company>Selbcity Inc.</company>
    </job>
    <job from="May 2003" until="Aug 2005">
      <occupation>Design</occupation>
      <company>Omnia Sports</company>
    </job>
    <job from="Mar 2001" until="Jul 2003">
      <occupation>Konzeption &amp; Design</occupation>
      <company>alombra new media</company>
    </job>
  </jobhistory>
</profile>
```