createStep({
	getUrl: function( ctx ) {
		return "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/NES_roms_summary%200-L.htm";
	},
	run: function( ctx ) {
	
		var xml = new XML( ctx.getResponse() );
	
		for each( var link in xml..a.@href ) {
		
			nesLink = String(link);
			
			if ( nesLink.match(/.zip$/) ) {  
				
				var downloadUrl = "http://www.theoldcomputer.com/Libarary%27s/Emulation/NES/ROMs/"+escape( nesLink );
				
				ctx.addDownload( downloadUrl, "/Users/alombra/Desktop/test/"+nesLink );
				
			}
		}
	}
});