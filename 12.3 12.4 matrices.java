  //12.3 Manejo de Matrices Parte 3: Ciclo for iterando
        System.out.println("Recorremos la matriz a traves del ciclo for");

        for (int fila = 0; fila < edades.length; fila++) {
            for (int col = 0; col < edades[fila].length; col++) {
                System.out.println("Edades " + fila + "-" + col + ": " + edades[fila][col]);

            }
        }

        // 12.4 Manejo de Matrices Parte 4: Sintaxis simplificada
        //Sintaxis clasica
        //String frutas[][] = new String[3][2];
        //Sintaxis Simplificada
        String frutas[][] = {{"Limon", "Pomelo"}, {"Ciruela", "Kiwi"}, {"Banana", "Manzana"}};
        imprimir(frutas);

//        for (int i = 0; i < frutas.length; i++) {
//            for (int col = 0; col < frutas[i].length; col++) {
//                System.out.println("frutas " + i + "-" + col + ": " + frutas[i][col]);
//            }