/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.AScenarioManager;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.UncompletedMethodException;



/*******************************************************************************
 * Instances of the {@code IGSMFactory } interface represent
 * the factory objects which are able to deliver the game instance,
 * an instance of scenario manager of this game
 * and an instance of the text user interface.
 * As long as some of these objects are not yet fully defined,
 * the methods may throw the
 * {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.UncompletedMethodException}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IGSMFactory
         extends IAuthor
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================

    /***************************************************************************
     * Returns the instance of the given factory class with a nullary
     * (=&nbsp;parameterless) constructor.
     *
     * @param <T>           Factory class type
     * @param factoryClass  Factory class class-object
     * @return Factory object
     * @throws IllegalArgumentException Creation of the instance failed
     */
    public static <T extends IGSMFactory>
           T getInstanceOfFactory(Class<T> factoryClass)
    {
        T result;
        try {
            result = factoryClass.newInstance();
        }
        catch (Exception ex) {
            throw new IllegalArgumentException(
                "\nFailed creation of instance of the " + factoryClass, ex);
        }
        return result;
    }



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================
//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================

    /***************************************************************************
     * Returns the instance of the scenario manager.
     * Until the appropriate class is not fully defined,
     * it throws the {@link UncompletedMethodException}.
     *
     * @return Required scenario manager
     * @throws UncompletedMethodException
     *         The class defining the textual user interface is not yet
     *         acceptable (= testable).
     */
//    @Override
    public default AScenarioManager getScenarioManager()
    {
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the instance of text version of the game.
     * Until the appropriate class is not fully defined,
     * it throws the {@link UncompletedMethodException}.
     *
     * @return Required game
     * @throws UncompletedMethodException
     *         The class defining the textual user interface is not yet
     *         acceptable (= testable).
     */
//    @Override
    public default IGame getGame()
    {
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the object executing the user interface.
     * Until the appropriate class is not fully defined,
     * it throws the {@link UncompletedMethodException}.
     *
     * @return Required user interface
     * @throws UncompletedMethodException
     *         The class defining the textual user interface is not yet
     *         acceptable (= testable).
     */
//    @Override
    public default IUI getUI()
    {
        throw new UncompletedMethodException();
    }



//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
