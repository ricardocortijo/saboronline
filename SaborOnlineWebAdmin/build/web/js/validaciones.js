
	function validar() {
		if (document.form.txtNombre.value == "") {
			alert('Ingrese nombre');
			return false;
		} else if (document.form.txtNombre.value == "") {
			alert('Ingrese clave');
			return false;
		} else if (document.form.txtDescripcion.value == "") {
			alert('Ingrese la descripcion');
			return false;
		} else if (document.form.txtPrecio.value == "") {
			alert('Ingrese el precio');
			return false;
		} else if (document.form.txtStock.value == "") {
			alert('Ingrese el stock');
			return false;
		}else if (document.form.txtImportancia.value == "") {
			alert('Ingrese la importancia');
			return false;
		}
		return true;
	}
