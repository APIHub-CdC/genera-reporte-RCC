package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Persona {
    private Encabezado encabezado;
    private Nombre nombre;
    private Domicilios domicilios;
    private Empleos empleos;
    private Mensajes mensajes;
    private Cuentas cuentas;
    private TendenciasFinancieras tendenciasFinancieras;
    private EstadisticasFinancieras estadisticasFinancieras;
    //private ResumenCuentas resumenCuentas;
    private ConsultasEfectuadas consultasEfectuadas;
    private String declaracionesConsumidor;
    private Autenticacion autenticacion;
    private Scores scores;
    
    
    //campos nuevos
    private Graficas graficas;
    private Boolean flagNoEmpresarial  = false;
    private Boolean flagEmpresarial  = false;
    private ResumenPorProducto resumenPorProducto;
    private DescripcionRazones descripcionRazones;
    private Boolean consolidado = false;
    private String fechaConsultaTexto;
    private String folioConsultaBC;
    private Boolean mostrarMensajesPld  = false;
    private Boolean mostrarMensajes  = false;
    private CuentasCan cuentasCan;
    
    
    
    
    

	public CuentasCan getCuentasCan() {
		return cuentasCan;
	}

	public void setCuentasCan(CuentasCan cuentasCan) {
		this.cuentasCan = cuentasCan;
	}

	@XmlElement(name ="mostrarMensajesPld")
    public Boolean getMostrarMensajesPld() {
		return mostrarMensajesPld;
	}

	public void setMostrarMensajesPld(Boolean mostrarMensajesPld) {
		this.mostrarMensajesPld = mostrarMensajesPld;
	}

	@XmlElement(name ="mostrarMensajes")
	public Boolean getMostrarMensajes() {
		return mostrarMensajes;
	}

	public void setMostrarMensajes(Boolean mostrarMensajes) {
		this.mostrarMensajes = mostrarMensajes;
	}

	@XmlElement(name ="fechaConsultaTexto")
    public String getFechaConsultaTexto() {
		return fechaConsultaTexto;
	}

	public void setFechaConsultaTexto(String fechaConsultaTexto) {
		this.fechaConsultaTexto = fechaConsultaTexto;
	}

	@XmlElement(name ="folioConsultaBC")
	public String getFolioConsultaBC() {
		return folioConsultaBC;
	}

	public void setFolioConsultaBC(String folioConsultaBC) {
		this.folioConsultaBC = folioConsultaBC;
	}

	@XmlElement(name ="consolidado")
    public Boolean getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(Boolean consolidado) {
		this.consolidado = consolidado;
	}

	@XmlElement(name ="DescripcionRazones")
    public DescripcionRazones getDescripcionRazones() {
		return descripcionRazones;
	}

	public void setDescripcionRazones(DescripcionRazones descripcionRazones) {
		this.descripcionRazones = descripcionRazones;
	}

	@XmlElement(name ="EstadisticasFinancieras")
    public EstadisticasFinancieras getEstadisticasFinancieras() {
		return estadisticasFinancieras;
	}

	public void setEstadisticasFinancieras(EstadisticasFinancieras estadisticasFinancieras) {
		this.estadisticasFinancieras = estadisticasFinancieras;
	}

	@XmlElement(name ="TendenciasFinancieras")
    public TendenciasFinancieras getTendenciasFinancieras() {
		return tendenciasFinancieras;
	}

	public void setTendenciasFinancieras(TendenciasFinancieras tendenciasFinancieras) {
		this.tendenciasFinancieras = tendenciasFinancieras;
	}

	@XmlElement(name ="Empleos")
    public Empleos getEmpleos() {
		return empleos;
	}
    
    @XmlElement(name ="DeclaracionesConsumidor")
	public String getDeclaracionesConsumidor() {
		return declaracionesConsumidor;
	}

	/*@XmlElement(name ="ResumenCuentas")
    public ResumenCuentas getResumenCuentas() {
		return resumenCuentas;
	}

	public void setResumenCuentas(ResumenCuentas resumenCuentas) {
		this.resumenCuentas = resumenCuentas;
	}*/

	@XmlElement(name ="Autenticacion")
	public Autenticacion getAutenticacion() {
		return autenticacion;
	}

	public void setAutenticacion(Autenticacion autenticacion) {
		this.autenticacion = autenticacion;
	}

	@XmlElement(name ="FlagNoEmpresarial")
	public Boolean getFlagNoEmpresarial() {
		return flagNoEmpresarial;
	}

	public void setEmpleos(Empleos empleos) {
		this.empleos = empleos;
	}

	public void setDeclaracionesConsumidor(String declaracionesConsumidor) {
		this.declaracionesConsumidor = declaracionesConsumidor;
	}

	@XmlElement(name ="Encabezado")
    public Encabezado getEncabezado() {
        return encabezado;
    }

    @XmlElement(name ="Nombre")
    public Nombre getNombre() {
        return nombre;
    }

    @XmlElement(name ="Domicilios")
    public Domicilios getDomicilios() {
        return domicilios;
    }

    @XmlElement(name ="Mensajes")
    public Mensajes getMensajes() {
        return mensajes;
    }

    @XmlElement(name ="Cuentas")
    public Cuentas getCuentas() {
        return cuentas;
    }

    @XmlElement(name ="ConsultasEfectuadas")
    public ConsultasEfectuadas getConsultasEfectuadas() {
        return consultasEfectuadas;
    }

    @XmlElement(name ="Scores")
    public Scores getScores() {
        return scores;
    }
    
    @XmlElement(name ="Graficas")
    public Graficas getGraficas() {
        return graficas;
    }

    @XmlElement(name ="ResumenPorProducto")
    public ResumenPorProducto getResumenPorProducto() {
        return resumenPorProducto;
    }
    
    @XmlElement(name ="FlagEmpresarial")
    public Boolean getFlagEmpresarial() {
        return flagEmpresarial;
    }

    
    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    public void setNombre(Nombre Nombre) {
        this.nombre = Nombre;
    }

    public void setDomicilios(Domicilios domicilios) {
        this.domicilios = domicilios;
    }

    public void setMensajes(Mensajes mensajes) {
        this.mensajes = mensajes;
    }

    public void setCuentas(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void setConsultasEfectuadas(ConsultasEfectuadas consultasEfectuadas) {
        this.consultasEfectuadas = consultasEfectuadas;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public void setGraficas(Graficas graficas) {
        this.graficas = graficas;
    }
    
    public void setResumenPorProducto(ResumenPorProducto resumenPorProducto) {
        this.resumenPorProducto = resumenPorProducto;
    }
    
    public void setFlagNoEmpresarial(Boolean flagNoEmpresarial) {
        this.flagNoEmpresarial = flagNoEmpresarial;
    }
    
    public void setFlagEmpresarial(Boolean flagEmpresarial) {
        this.flagEmpresarial = flagEmpresarial;
    }

}
