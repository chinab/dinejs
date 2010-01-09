createStep({
	getUrl: function( ctx ) {
		return "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/NES_roms_summary%200-L.htm";
	},
	run: function( ctx ) {
	
		// create an E4X object from the XML response
		var xml = new XML( ctx.getResponse() );
	
		// find all links on the page
		for each( var link in xml..a.@href ) {
		
			nesLink = String( link );
			
			// do they link to a .zip file?
			if ( nesLink.match(/.zip$/) ) {  
				
				// complete url to zip file
				var downloadUrl = "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/"+escape( nesLink );				
				
				// trigger download
				ctx.addDownload( downloadUrl, nesLink );				
			}
		}
	}
});