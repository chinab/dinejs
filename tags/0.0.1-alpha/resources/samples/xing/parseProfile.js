createStep({
	getUrl: function() {
		return this.params.url;
	},
	run: function() {		
			
			var name			 = String( this.xmlObj..title ).replace(/XING - /, "");
			var occupation = this.xmlObj..p.(@className="profile-work-descr")..a[0];
			
			var result = 	<profile>
											<name>{name}</name>
											<occupation>{String(occupation)}</occupation>
											<url>{this.memory.url}</url>
										</profile>;
											
			print( result.toXMLString() );
	}
});