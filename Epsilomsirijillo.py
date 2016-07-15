print """
+_____________________________________+
|   ____     ____   ___  ___     ___  |
|  /  __\   |   /  /  / \   \   |   | |
| /  /      |  /  /  /   \   \  /  /  |
| \  \__    |  |_/  /     \   \/  /   |
|  \___ \   |	 __/ 	   \	 /    |
|      \ \  |  \  \         \   /     |
|   ___/ /  |  |\  \	    /  /      |
|  /____/   |__| \__\      |__/       |
|                                     |
|               Lite                  |
+_____________________________________+
"""
op = "1"
while op == "1":
	cadena = raw_input("""Inserte un conjunto separado por comas -> Ej: {ab,ba}
	->  """)
	cadena = cadena + ","
	lista = []
	aux = ""
	for i in range(0, len(cadena)):
		if cadena[i] !="," :
			aux = aux + cadena[i]
		else:
			lista.append(aux)
			aux = ""
	a = "{"
	b = "{"
	c = "{"
	d = "{"
	for i in range(0, len(lista)):
	
		for j in range(0, len(lista)):
	    
			for k in range(0, len(lista)):
			
				for l in range(0, len(lista)):
					d = d + lista[i]+lista[j]+lista[k]+lista[l]+","
				c = c + lista[i]+lista[j]+lista[k]+","		
			b = b + lista[i]+lista[j]+","	
		a = a + lista[i]+","	

	a = a + "}"
	b = b + "}"
	c = c + "}"
	d = d + "}"
	print "A^0 = E"
	print "A^1 = "+a
	print "A^2 = "+b
	print "A^3 = "+c
	print "A^4 = "+d
	print "Desea ingresar otra cadena ? 1.- Si Presione otra tecla para salir"
	op = raw_input()
