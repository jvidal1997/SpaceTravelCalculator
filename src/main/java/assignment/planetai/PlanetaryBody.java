/**
 * This class is intended to represent a planetary body.
 *
 * @author J. Vidal
 * 09.07.2024
 */
package assignment.planetai;

import assignment.util.ScientificCalc;
import edu.ccri.assignment.planets.data.DataAccessElement;

/**
 * This class represents a planetary body.
 * <br><br>
 * A planetary body has the following attributes:
 * <ul>
 *     <li>name</li>
 *     <li>classification</li>
 *     <li>diameter</li>
 *     <li>weight ratio to earth</li>
 *     <li>distance from earth</li>
 *     <li>distance from the sun</li>
 *     <li>orbital eccentricity</li>
 *     <li>albedo</li>
 *     <li>day length</li>
 *     <li>year length</li>
 *     <li>drag coefficient</li>
 *     <li>orbital velocity</li>
 * </ul>
 */
public abstract class PlanetaryBody implements DataAccessElement {
    // ATTRIBUTES
    /**
     * The name of the planet
     */
    private String planetaryName;
    /**
     * The classification of the planet
     */
    private String classification;
    /**
     * The diameter of the planet
     */
    private double diameter;
    /**
     * The weight ratio to earth
     */
    private double weightToEarth;
    /**
     * The distance from earth
     */
    private double distanceFromEarth;
    /**
     * The distance from the sun
     */
    private double distanceFromSun;
    /**
     * The orbital eccentricity
     */
    private double OrbitalEcc;
    /**
     * The albedo
     */
    private double Albedo;
    /**
     * The length of a day in hours
     */
    private double DayLength;
    /**
     * The length of a year in days
     */
    private double YearLength;
    /**
     * The drag coefficient
     */
    private double dragCoefficient;
    /**
     * The orbital velocity
     */
    private double orbitalVelocity;


    // CONSTRUCTORS
    /**
     * This is an empty instance of the {@link PlanetaryBody} class.
     */
    public PlanetaryBody() {}

    /**
     * Instantiates a <b>PlanetaryBody</b> object and it's corresponding attributes.
     * @param name the name
     * @param type the classification
     * @param dia the diameter
     * @param weight the weight ratio to earth
     * @param dFromE the distance from earth
     * @param dFromS the distance from the sun
     * @param oe the orbital eccentricity
     * @param al the albedo
     * @param dayLen the length of a day in hours
     * @param yrLen the length of a year in days
     */
    public PlanetaryBody(String name, String type, double dia, double weight, double dFromE, double dFromS, double oe, double al, double dayLen, double yrLen) {
        setPlanetaryName(name);
        setClassification(type);
        setDiameter(dia);
        setWeight(weight);
        setDistanceFromEarth(dFromE);
        setDistanceFromSun(dFromS);
        setOrbitalEcc(oe);
        setAlbedo(al);
        setDayLength(dayLen);
        setYearLength(yrLen);
        setDragCoefficient();
        setOrbitalVelocity();
    }

    // SETTERS
    /**
     * Sets the current instance's <i>PlanetaryName</i>
     * @param name the name to assign
     */
    public void setPlanetaryName(String name) { this.planetaryName = name; }

    /**
     * Sets the current instance's <i>classification</i>
     * @param type the type to assign
     */
    public void setClassification(String type) { this.classification = type; }

    /**
     * Sets the current instance's <i>diameter</i>
     * @param dia the diameter to assign
     */
    public void setDiameter(double dia) { this.diameter = dia; }

    /**
     * Sets the current instance's <i>weightToEarth</i>
     * @param weight the earth-comparative weight to assign
     */
    public void setWeight(double weight) { this.weightToEarth = weight; }

    /**
     * Sets the current instance's <i>distanceFromEarth</i>
     * @param dFromE the distance from earth to assign
     */
    public void setDistanceFromEarth(double dFromE) { this.distanceFromEarth = dFromE; }

    /**
     * Sets the current instance's <i>distanceFromSun</i>
     * @param dFromS the distance from the sun to assign
     */
    public void setDistanceFromSun(double dFromS) {this.distanceFromSun = dFromS;}

    /**
     * Sets the current instance's <i>OrbitalEcc</i>
     * @param oe the orbital eccentricity to assign
     */
    public void setOrbitalEcc(double oe) {this.OrbitalEcc = oe;}

    /**
     * Sets the current instance's <i>Albedo</i>
     * @param al the albedo to assign
     */
    public void setAlbedo(double al) {this.Albedo = al;}

    /**
     * Sets the current instance's <i>DayLength</i>
     * @param dayLen the planetary body's length of a day in hours
     */
    public void setDayLength(double dayLen) {this.DayLength = dayLen;}

    /**
     * Sets the current instance's <i>YearLength</i>
     * @param yrLen the planetary body's length of a year in days
     */
    public void setYearLength(double yrLen) {this.YearLength = yrLen;}

    /**
     *  Sets the current instance's <i>dragCoefficient</i>, according to its classification.
     */
    public void setDragCoefficient() { this.dragCoefficient = ScientificCalc.dragCoefficient(this.planetaryName, this.classification, this.Albedo, this.OrbitalEcc); }

    /**
     * Sets the current instance's <i>orbitalVelocity</i> to the calculated value.
     *
     * @see ScientificCalc#orbitalVelocity(double, double)
     */
    public void setOrbitalVelocity() { this.orbitalVelocity = ScientificCalc.orbitalVelocity(this.distanceFromSun, this.YearLength); }

    // GETTERS
    /**
     * Returns the name of the planetary body.
     * @return (String) name
     */
    public String getName() {
        return this.getPlanetaryName();
    }

    /**
     * Returns the name of the planetary body.
     * @return (String) planetaryName
     */
    public String getPlanetaryName() { return planetaryName; }

    /**
     * Returns the classification of the planetary body.
     * @return (String) classification
     */
    public String getClassification() { return classification; }

    /**
     * Returns the diameter of the planetary body.
     * @return (double) diameter
     */
    public double getDiameter() { return diameter; }

    /**
     * Returns the comparable weight of the planetary body to earth.
     * @return (double) weightToEarth
     */
    public double getWeight() { return weightToEarth; }

    /**
     * Returns the planetary body's distance to Earth.
     * @return (double) distanceFromEarth
     */
    public double getDistanceFromEarth() { return distanceFromEarth; }

    /**
     * Returns the planetary body's distance from the sun.
     * @return (double) distanceFromSun
     */
    public double getDistanceFromSun() { return distanceFromSun; }

    /**
     * Returns the planetary body's orbital eccentricity.
     * @return (double) OrbitalEcc
     */
    public double getOrbitalEcc() { return OrbitalEcc; }

    /**
     * Returns the planetary body's albedo.
     * @return (double) Albedo
     */
    public double getAlbedo() { return Albedo; }

    /**
     * Returns the planetary body's length of a day in hours.
     * @return (double) DayLength
     */
    public double getDayLength() { return DayLength; }

    /**
     * Returns the planetary body's length of a year in days.
     * @return (double) YearLength
     */
    public double getYearLength() { return YearLength; }

    /**
     * Returns the planetary body's drag coefficient.
     * @return (double) dragCoefficient
     */
    public double getDragCoefficient() { return dragCoefficient; }

    /**
     * Returns the orbital velocity of the planetary body.
     * @return (double) orbitalVelocity
     */
    public double getOrbitalVelocity() { return orbitalVelocity; }


    // METHODS
    /**
     * Returns a string representation of the {@link PlanetaryBody} object, containing the following attributes:
     * <ul>
     *      <li>planetary name</li>
     *      <li>classification</li>
     *      <li>diameter</li>
     *      <li>weight to earth</li>
     *      <li>distance from earth</li>
     *      <li>distance from sun</li>
     *      <li>orbital eccentricity</li>
     *      <li>albedo</li>
     *      <li>day length</li>
     *      <li>year length</li>
     *      <li>drag coefficient</li>
     * </ul>
     *
     * @return a string representation of the {@link PlanetaryBody} object
     */
    @Override
    public String toString() {
        return String.format("%s | %s | %.1f | %.6f | %.2f | %.2f | %.4f | %.3f | %.3f | %.3f | %.6f", this.planetaryName, this.classification, this.diameter, this.weightToEarth, this.distanceFromEarth, this.distanceFromSun, this.OrbitalEcc, this.Albedo, this.DayLength, this.YearLength, this.dragCoefficient);
    }

}
