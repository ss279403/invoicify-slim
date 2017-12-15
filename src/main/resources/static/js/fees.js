$(function() {

	$('#create-flat-fee').submit(function(e) {
		e.preventDefault();

		let flatfee = {
			amount: $('#amount').val(),
			description: $('#description').val(),
			client: {
				id: $('#clientId').val()
			}
			
		};

		let headers = {
			'X-CSRF-TOKEN': $('#flatfee-csrf').val()

		};

		let settings = {
			url: '/api/flatfees',
			headers: headers,
			data: JSON.stringify(flatfee),
			contentType: 'application/json'
		};

		$.post(settings).done(function(data) {
			console.log(data);
				$('#fee-table')
					.append(`
				<tr>
					<td>${ data.createdBy.username }</td>		
					<td>${ data.description }</td>
					<td>${ data.client.name }</td>
					<td>$${ data.amount }</td>
					<td>${ "" }</td>
					<td>${ "" }</td>
					<td>$${ data.total }</td>
				</tr>`);
				$('#amount').val(''),
				$('#description').val(''),
				$('#clientId').val('');

		});
	});
	
	$('#create-rate-fee').submit(function(e) {
		e.preventDefault();
		
		let ratefee = {
				rate: $('#rate').val(),
				quantity: $('#quantity').val(),
				description: $('#rate-description').val(),
				client: {
					id: $('#rate-clientId').val()
				}
				
			};
		
		let headers = {
				'X-CSRF-TOKEN': $('#ratefee-csrf').val()

			};
		
		let settings = {
				url: '/api/ratefees',
				headers: headers,
				data: JSON.stringify(ratefee),
				contentType: 'application/json'
			};
		
		$.post(settings).done(function(data) {
			console.log(data);
				$('#fee-table')
					.append(`
				<tr>
					<td>${ data.createdBy.username }</td>		
					<td>${ data.description }</td>
					<td>${ data.client.name }</td>
					<td>${ "" }</td>
					<td>$${ data.rate } </td>
					<td>${ data.quantity } </td>
					<td>$${ data.total }</td>
				</tr>`);
				
				$('#rate').val(''),
				$('#quantity').val(''),
				$('#rate-description').val(''),
				$('#rate-clientId').val('');
				
		});
	});	

});