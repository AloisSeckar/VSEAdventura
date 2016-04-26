/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.CallerReporter.Level;



/*******************************************************************************
 * Instances of the {@code UncompletedMethodException} class are thrown
 * to indicate that the requested method is not yet completed.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
@SuppressWarnings("serial")
public class UncompletedMethodException extends RuntimeException
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Constructs an {@code UncompletedException} with no detail message.
     */
    public UncompletedMethodException()
    {
        this("", true);
    }


    /***************************************************************************
     * Constructs an {@code UncompletedException}
     * with the specified detail trailing message.
     *
     * @param message The detail message put at the end of the announcement
     *                of the method creating this exception
     */
    public UncompletedMethodException(String message)
    {
        this(message, (message == null) || message.isEmpty());
    }


    /***************************************************************************
     * Constructs an {@code UncompletedException}
     * with the specified detail trailing message.
     *
     * @param message The detail message put at the end of the announcement
     *                of the method creating this exception
     * @param withoutMessage If the empty message is set
     */
    private UncompletedMethodException(String message, boolean withoutMessage)
    {
        super("\nThe called method is not yet completed: "
              + CallerReporter.getCallerName(Level.CLASS, 2)
              + (withoutMessage  ?  ""  :  ('\n' + message)));
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
