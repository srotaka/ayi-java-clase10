package org.example.utilities;

public class DatosRandom {

    public String nombreRandom() {

        String[] nombres = {"AGUSTÍN", "ALBA", "ALBERTO", "AMBAR", "ANTONIA", "BAUTISTA", "BENJAMÍN", "BRUNO", "CARINA", "CARLOS", "CIRO", "CRISTÓBAL", "DANIEL", "DELFINA", "EMILIA", "ERNESTO", "EVANGELINA", "FAUSTO", "FELIPE", "FRANCO", "GEORGINA", "GIOVANNA", "GISELLE", "GLORIA", "HERNAN", "IGNACIO", "CLAUDIA", "ISABELLA", "JAZMÍN", "JOAQUÍN", "JORGE", "JOSÉ", "FABIÁN", "JULIA", "LORELEY", "LORENA", "MELINA", "LUCAS", "LUZ", "MANUEL", "MARÍA", "MARIANA", "MARTÍN", "MATEO", "MIRIAN", "MIRNA", "YANET", "NORBERTO", "OSCAR", "PILAR", "ROBERTO", "RODRIGO", "SILVANA", "SILVINA", "SOFÍA", "TEO", "TOMAS", "VERA", "VICENTE", "VICTORIA"};
        String nombre = nombres[(int) (Math.random() * 60)];
        return nombre;
    }

    public String apellidoRandom() {

        String[] apellidos = {"ADAMS", "ALLEN", "ANDERSON", "BAKER", "BARKER", "BELL", "BENNET", "BROWN", "BUTLER", "CAGE", "CAMPBELL", "CARTER", "CHAPMAN", "CLARK", "COOK", "DAVIS", "EDWARDS", "FISHER", "FOSTER", "GRAHAM", "GRAY", "GREEN", "HALL", "HARRIS", "HARVEY", "HILL", "HOLMES", "HUNT", "JACKSON", "JOHNSON", "JONES", "KING", "LEE", "LEWIS", "MARSHALL", "MILLER", "MITCHELL", "MOORE", "MORRIS", "OWEN", "PALMER", "PEARSON", "POWELL", "PRICE", "ROBERTS", "ROBINSON", "RUSSELL", "SCOTT", "SMITH", "STEWART", "TAYLOR", "THOMPSON", "WALKER", "WEBB", "WHITE", "WILKINSON", "WILLIAMS", "WILSON", "WOOD", "YOUNG"};
        String apellido = apellidos[(int) (Math.random() * 60)];
        return apellido;
    }

    public String direccionRandom() {

        String[] calles = {"3 DE FEBRERO", "9 DE JULIO", "ALEM", "ALVEAR", "AVELLANEDA", "AYACUCHO", "BALCARCE", "BELGRANO", "BERUTTI", "BROWN", "BUENOS AIRES", "CAFFERATA", "CATAMARCA", "CHACABUCO", "COCHABAMBA", "COLON", "CORDOBA", "CORRIENTES", "DORREGO", "ENTRE RIOS", "FRANCIA", "GALVEZ", "IRIONDO", "ITALIA", "ITUZAINGO", "JUAN MANUEL ROSAS", "JUJUY", "LAPRIDA", "MAIPU", "MENDOZA", "MISIONES", "MITRE", "MONTEVIDEO", "MORENO", "NECOCHEA", "OCAMPO", "OROZCO", "OVIDIO LAGOS", "PARAGUAY", "PELLEGRINI", "PRESIDENTE ROCA", "PUEYRREDON", "RICCHIERI", "RIOBAMBA", "RIOJA", "RODRIGUEZ", "SAN JUAN", "SAN LORENZO", "SAN LUIS", "SAN MARTIN", "SAN NICOLAS", "SANTA FE", "SANTIAGO", "SARMIENTO", "SUIPACHA", "TUCUMAN", "URQUIZA", "VIAMONTE", "WHEELWRIGHT", "ZEBALLOS"};
        String calle = calles[(int) (Math.random() * 60)];

        int altura = (int) ((Math.random() * (5999 - 113)) + 113);
        return calle + " " + altura;
    }
    public String ciudadRandom(){
        String[] ciudades = {"ROSARIO", "POSADAS", "CORRIENTES", "PARANÁ", "MENDOZA", "CÓRDOBA", "SANTA ROSA", "CHIVILCOY", "MAR DEL PLATA", "SAN MIGUEL DE TUCUMÁN", "SALTA", "SANTA FE", "BAHÍA BLANCA", "RESISTENCIA", "MERLO", "QUILMES", "SAN SALVADOR DE JUJUY", "SANTIAGO DEL ESTERO", "BANFIELD", "NEUQUÉN", "FORMOSA", "LANÚS", "LA PLATA", "GODOY CRUZ", "LAS HERAS", "BERAZATEGUI", "LA RIOJA", "COMODORO RIVADAVIA", "SAN FERNANDO DEL VALLE DE CATAMARCA", "RÍO CUARTO", "RAWSON", "BARILOCHE", "TRELEW", "RÍO GALLEGOS", "SAN LUIS", "SAN JUAN", "VIEDMA", "IGUAZÚ", "SAN RAFAEL", "SANTA ROSA", "ALTA GRACIA", "RECONQUISTA", "USHUAIA", "VILLA CARLOS PAZ", "OBERÁ", "ITUZAINGÓ", "LOMAS DE ZAMORA", "LUJÁN", "PERGAMINO", "CONCORDIA", "NECOCHEA", "OLAVARRÍA", "PINAMAR", "TIGRE", "ZÁRATE", "MONTE GRANDE", "LOS POLVORINES", "MONTECARLO", "ELDORADO", "CHACABUCO"};
        String ciudad = ciudades[(int) (Math.random() * 60)];
        return  ciudad;
    }

    public String puestoRandom(){
        String[] puestos = {"MARKETING", "PROMOCIONES", "COMMUNITY MANAGER", "VENTA MINORISTA", "VENTA MAYORISTA", "VENTA EXTRANJERO", "DISTRIBUCIÓN", "FACTURACIÓN CLIENTES", "FACTURACIÓN INTERNA", "PLANIFICACIÓN FINANCIERA", "FORMULACIÓN DE PRESUPUESTOS", "TESORERÍA", "CRÉDITOS", "COBRANZAS", "CAJA", "CONTABILIDAD FINACIERA", "CONTABILIDAD DE COSTOS", "CONTABILIDAD PATRIMONIAL", "ANÁLISIS DE STOCK", "GESTIÓN Y CONTRATACIÓN", "RECEPCIÓN", "DEPÓSITO", "EXPEDICIONES", "CONTROL DE STOCK", "COMUNICACIONES", "TRANSPORTES", "TALLER", "MANTENIMIENTO E INSTALACIONES", "SEGURIDAD Y VIGILANCIA", "ARCHIVO Y DOCUMENTACIÓN", "CAFETERÍA", "SERVICIO MÉDICO", "PLANIFICACIÓN DE RR.HH.", "RECLUTAMIENTO Y SELECCIÓN", "CONTRATACIÓN E INDUCCIÓN DE RR.HH.", "CONTROL DE PERSONAL", "LIQUIDACIÓN DE SUELDOS", "CAPACITACIÓN Y DESARROLLO", "SEGURIDAD E HIGIENE", "SOPORTE TÉCNICO", "SOPORTE DE REDES", "PROGRAMADOR JR.", "PROGRAMADOR SR.","PROGRMADOR SSR.", "PROGRAMADOR TRAINEE", "DESARROLLADOR WEB", "ANALISTA DE SISTEMAS", "INGENIERO DE REDES", "UX/UI", "CIENTÍFICO DE DATOS", "DBA", "ESPECIALISTA EN SEGURIDAD INFORMÁTICA", "ADMINISTRADOR WEB", "CEO", "CTO","CIO", "CONTROL DE RIESGOS", "ATENCIÓN AL USUARIO", "INFRAESTRUCTURA", "PROJECT MANAGER"};
        String puesto = puestos[(int) (Math.random() * 60)];
        return  puesto;
    }

    public Integer idRandom(){
        int id = (int) ((Math.random() * (2147483647 - 1)) + 1);
        return id;
    }

    public Double sueldoRandom(){
        Double sueldo = Math.round(((Math.random() * (9999 - 1000)) + 1000)*100.0)/100.0;
        return sueldo;
    }

    public Integer edadRandom(){
        int edad = (int) ((Math.random() * (94 - 13)) + 13);
        return edad;
    }

    public String vipRandom(){
        String[] vipStatus ={" CLIENTE_VIP", "CLIENTE_NO_VIP"};
        String vip = vipStatus[(int) (Math.random() * 2)];
        return vip;
    }

}