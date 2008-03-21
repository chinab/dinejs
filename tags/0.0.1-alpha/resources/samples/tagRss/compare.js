createExecutable({

	run: function() {		
		
		var keys = this.memoryKeys();
		var taggedResults = {};
		
		for ( n=0; n<keys.length; n++ )		
			taggedResults[ keys[n] ] = new XML( this.fromMemory( keys[n] ) ); 

		var urlC = 0;

		for ( var url in taggedResults ) {
		
			var otherUrlC = 0; 
				
			for ( var otherUrl in taggedResults ) {
									
				if ( urlC < otherUrlC && extractDomainName( url ) != extractDomainName( otherUrl) ) {
		
					var rate = 0;
					
					rate += compareXML( taggedResults, url, otherUrl, "topic" );
					rate += compareXML( taggedResults, url, otherUrl, "location" );
					rate += compareXML( taggedResults, url, otherUrl, "person" );

					rate = Math.ceil( ((rate/3)*100) );	
					
					if ( rate > 25 )
						print("MATCH ("+rate+"%): "+url+" | "+otherUrl );								
				}
				
				otherUrlC++;
			}
			
			urlC++;
		}

	}
});

function extractDomainName( url ) {

	domain = url.match( /:\/\/(www\.)?([^\/:]+)/ );

	return domain[2] ? domain[2] : '';
}

function compareXML( taggedResults, url, otherUrl, tagType ) {

					var urlTagNum 		= 0;
					var otherUrlTagNum 	= 0;	
					var matchingTagNum 	= 0;

					for each( var tag in taggedResults[url].tags.(@type=tagType).tag ) {
					
						urlTagNum++;
					
						for each( var otherTag in taggedResults[otherUrl].tags.(@type=tagType).tag ) {						
							
							otherUrlTagNum++;

							if ( String(tag) == String(otherTag) )
								matchingTagNum++;
						}
					}		

					if ( urlTagNum == 0 ) return 0;

					otherUrlTagNum = otherUrlTagNum/urlTagNum;
					
					var tagNum = Math.max( urlTagNum, otherUrlTagNum );

					return ( urlTagNum != 0 ) ? matchingTagNum/tagNum : 0;	 
}

