var Class = {
	create: function( parent, def ) {

    if ( arguments.length == 1 ) def = parent, parent = null;

		var func = function() {};

		if ( parent != null && typeof( parent == "function" ) )
			func.prototype = new parent();	

		if ( def )
			for ( var prop in def )
				func.prototype[prop] = def[prop];

		return func;
	}
};

var BaseStep = Class.create({

	  xmlObj: 					null,
	  memory: 					{},
	  httpResponseCode: null,
		
		setXmlStr: function( xmlStr ) {
			this.xmlObj = new XML( xmlStr );
		},
		
		addMemoryAttribute: function( key, value ) {
			this.memory[key] = value;			
		},
		
		setHttpResponse: function( code ) {
			this.httpResponseCode = code;
		}
});

function createStep( stepImpl ) {
	var CustomStep = Class.create( BaseStep, stepImpl );
	
	creator.setStep( 
		new Packages.de.alombra.dine.steps.Step( new CustomStep() ) 
	);	
}

function addStep( stepName, stepMemoryProperties ) {

	//TODO inherit memory
  var memory = new Packages.de.alombra.dine.steps.StepMemory();
  
	for ( var prop in stepMemoryProperties )
		memory.setAttribute( prop, stepMemoryProperties[prop] );

	executionContext.addStep( stepName, memory );
}
