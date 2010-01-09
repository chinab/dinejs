createStep({
	getUrl: function( ctx ) {
	
		var firstname = "Lucas";
		var lastname =  "Schelter";
	
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