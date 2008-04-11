createStep({

	getGoogleKey: function() {
		return "ABQIAAAANelthjk4CgqkadrupPlamRSlTgugxDuQ-CJDMAyi6NoU3BK23hTgT8kdfXBI2kpzMkWdhx9SWYPvvg";
	},

	getUrl: function( ctx ) {
	
		var address = "Kiehlufer 43,12059,Berlin,DE"; 
	
		print( "Retrieving coordinates for "+address );
	
		// return the URI for our query
		return "http://maps.google.com/maps/geo?q="
				+ctx.encode( address ) 
				+"&output=json&key="
				+this.getGoogleKey();		
	},
	run: function( ctx ) {

		// create JS object from json response		
		var response = eval( "("+ctx.getResponse()+")");
		
		// status code 200 means everything's ok
		if ( response.Status.code == 200 ) {
			
			print("Successfully geocoded address for: "+response.name );
						
			// print latitude and longitude from the JSON response			
			print("Latitude: "+response.Placemark[0].Point.coordinates[1]+", Longitude: "+response.Placemark[0].Point.coordinates[0] );
				
		}		
		else {
			// something went wrong
			print("Unable to geocode address for: "+response.name+" [ERROR: "+response.Status.code+"]" );
		}

	}
	
});