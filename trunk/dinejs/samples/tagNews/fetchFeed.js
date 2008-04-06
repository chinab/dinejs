createStep({
	getUrl: function() {
		return "http://rss.cnn.com/rss/cnn_world.rss";
	},
	run: function() {		
			
		for each( var title in this.xmlObj..item..title ) {
			print( String(title) );
		}
	}
});