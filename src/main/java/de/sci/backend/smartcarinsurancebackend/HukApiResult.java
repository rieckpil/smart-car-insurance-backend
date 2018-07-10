package de.sci.backend.smartcarinsurancebackend;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "beitragGesamt",
        "beitragGesamtHkb",
        "beitragHaftpflichtMitSchutzbrief",
        "beitragHaftpflichtOhneSchutzbrief",
        "beitragVollkasko",
        "beitragTeilkasko",
        "beitragAnteilKaskoSelect",
        "beitragFahrerschutz",
        "beitragAuslandsschutz",
        "beitragUnfallmeldeDienst",
        "beitragRabattschutz",
        "sfHaftpflicht",
        "sfKasko"
})
public class HukApiResult {

    @JsonProperty("beitragGesamt")
    private Double beitragGesamt;
    @JsonProperty("beitragGesamtHkb")
    private Double beitragGesamtHkb;
    @JsonProperty("beitragHaftpflichtMitSchutzbrief")
    private Double beitragHaftpflichtMitSchutzbrief;
    @JsonProperty("beitragHaftpflichtOhneSchutzbrief")
    private Double beitragHaftpflichtOhneSchutzbrief;
    @JsonProperty("beitragVollkasko")
    private Double beitragVollkasko;
    @JsonProperty("beitragTeilkasko")
    private Double beitragTeilkasko;
    @JsonProperty("beitragAnteilKaskoSelect")
    private Integer beitragAnteilKaskoSelect;
    @JsonProperty("beitragFahrerschutz")
    private Integer beitragFahrerschutz;
    @JsonProperty("beitragAuslandsschutz")
    private Double beitragAuslandsschutz;
    @JsonProperty("beitragUnfallmeldeDienst")
    private Integer beitragUnfallmeldeDienst;
    @JsonProperty("beitragRabattschutz")
    private Double beitragRabattschutz;
    @JsonProperty("sfHaftpflicht")
    private String sfHaftpflicht;
    @JsonProperty("sfKasko")
    private String sfKasko;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("beitragGesamt")
    public Double getBeitragGesamt() {
        return beitragGesamt;
    }

    @JsonProperty("beitragGesamt")
    public void setBeitragGesamt(Double beitragGesamt) {
        this.beitragGesamt = beitragGesamt;
    }

    @JsonProperty("beitragGesamtHkb")
    public Double getBeitragGesamtHkb() {
        return beitragGesamtHkb;
    }

    @JsonProperty("beitragGesamtHkb")
    public void setBeitragGesamtHkb(Double beitragGesamtHkb) {
        this.beitragGesamtHkb = beitragGesamtHkb;
    }

    @JsonProperty("beitragHaftpflichtMitSchutzbrief")
    public Double getBeitragHaftpflichtMitSchutzbrief() {
        return beitragHaftpflichtMitSchutzbrief;
    }

    @JsonProperty("beitragHaftpflichtMitSchutzbrief")
    public void setBeitragHaftpflichtMitSchutzbrief(Double beitragHaftpflichtMitSchutzbrief) {
        this.beitragHaftpflichtMitSchutzbrief = beitragHaftpflichtMitSchutzbrief;
    }

    @JsonProperty("beitragHaftpflichtOhneSchutzbrief")
    public Double getBeitragHaftpflichtOhneSchutzbrief() {
        return beitragHaftpflichtOhneSchutzbrief;
    }

    @JsonProperty("beitragHaftpflichtOhneSchutzbrief")
    public void setBeitragHaftpflichtOhneSchutzbrief(Double beitragHaftpflichtOhneSchutzbrief) {
        this.beitragHaftpflichtOhneSchutzbrief = beitragHaftpflichtOhneSchutzbrief;
    }

    @JsonProperty("beitragVollkasko")
    public Double getBeitragVollkasko() {
        return beitragVollkasko;
    }

    @JsonProperty("beitragVollkasko")
    public void setBeitragVollkasko(Double beitragVollkasko) {
        this.beitragVollkasko = beitragVollkasko;
    }

    @JsonProperty("beitragTeilkasko")
    public Double getBeitragTeilkasko() {
        return beitragTeilkasko;
    }

    @JsonProperty("beitragTeilkasko")
    public void setBeitragTeilkasko(Double beitragTeilkasko) {
        this.beitragTeilkasko = beitragTeilkasko;
    }

    @JsonProperty("beitragAnteilKaskoSelect")
    public Integer getBeitragAnteilKaskoSelect() {
        return beitragAnteilKaskoSelect;
    }

    @JsonProperty("beitragAnteilKaskoSelect")
    public void setBeitragAnteilKaskoSelect(Integer beitragAnteilKaskoSelect) {
        this.beitragAnteilKaskoSelect = beitragAnteilKaskoSelect;
    }

    @JsonProperty("beitragFahrerschutz")
    public Integer getBeitragFahrerschutz() {
        return beitragFahrerschutz;
    }

    @JsonProperty("beitragFahrerschutz")
    public void setBeitragFahrerschutz(Integer beitragFahrerschutz) {
        this.beitragFahrerschutz = beitragFahrerschutz;
    }

    @JsonProperty("beitragAuslandsschutz")
    public Double getBeitragAuslandsschutz() {
        return beitragAuslandsschutz;
    }

    @JsonProperty("beitragAuslandsschutz")
    public void setBeitragAuslandsschutz(Double beitragAuslandsschutz) {
        this.beitragAuslandsschutz = beitragAuslandsschutz;
    }

    @JsonProperty("beitragUnfallmeldeDienst")
    public Integer getBeitragUnfallmeldeDienst() {
        return beitragUnfallmeldeDienst;
    }

    @JsonProperty("beitragUnfallmeldeDienst")
    public void setBeitragUnfallmeldeDienst(Integer beitragUnfallmeldeDienst) {
        this.beitragUnfallmeldeDienst = beitragUnfallmeldeDienst;
    }

    @JsonProperty("beitragRabattschutz")
    public Double getBeitragRabattschutz() {
        return beitragRabattschutz;
    }

    @JsonProperty("beitragRabattschutz")
    public void setBeitragRabattschutz(Double beitragRabattschutz) {
        this.beitragRabattschutz = beitragRabattschutz;
    }

    @JsonProperty("sfHaftpflicht")
    public String getSfHaftpflicht() {
        return sfHaftpflicht;
    }

    @JsonProperty("sfHaftpflicht")
    public void setSfHaftpflicht(String sfHaftpflicht) {
        this.sfHaftpflicht = sfHaftpflicht;
    }

    @JsonProperty("sfKasko")
    public String getSfKasko() {
        return sfKasko;
    }

    @JsonProperty("sfKasko")
    public void setSfKasko(String sfKasko) {
        this.sfKasko = sfKasko;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "HukApiResult{" +
                "beitragGesamt=" + beitragGesamt +
                ", beitragGesamtHkb=" + beitragGesamtHkb +
                ", beitragHaftpflichtMitSchutzbrief=" + beitragHaftpflichtMitSchutzbrief +
                ", beitragHaftpflichtOhneSchutzbrief=" + beitragHaftpflichtOhneSchutzbrief +
                ", beitragVollkasko=" + beitragVollkasko +
                ", beitragTeilkasko=" + beitragTeilkasko +
                ", beitragAnteilKaskoSelect=" + beitragAnteilKaskoSelect +
                ", beitragFahrerschutz=" + beitragFahrerschutz +
                ", beitragAuslandsschutz=" + beitragAuslandsschutz +
                ", beitragUnfallmeldeDienst=" + beitragUnfallmeldeDienst +
                ", beitragRabattschutz=" + beitragRabattschutz +
                ", sfHaftpflicht='" + sfHaftpflicht + '\'' +
                ", sfKasko='" + sfKasko + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}