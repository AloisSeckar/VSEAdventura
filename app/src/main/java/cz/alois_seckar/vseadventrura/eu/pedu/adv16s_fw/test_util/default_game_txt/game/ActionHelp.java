/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import java.util.Collection;
import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;


/*******************************************************************************
 * {@code ActionHelp} instances process the commands
 * that require the help.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionHelp extends AAction
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
     * Creates the action instance for
     * writing the help with names and brief descriptions of accessible commands.
     */
    ActionHelp()
    {
        super(Texts.aHELP,
        "It writes the help with name and brief description of all commands.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * The method returns texts of help consisting of
     * names and brief descriptions of accessible commands.
     *
     * @param arguments Parameters of the command - not used here
     * @return The message text written after accomplishing this command
     */
    @Override
    public String execute(String... arguments)
    {
        Collection<AAction> actions = getAllActions();
        String result = Stream.of(actions)
            .map(action -> '\n' + action.getName()
                         + '\n' + action.getDescription())
            .collect(Collectors.joining("\n\n", Texts.mHELP, ""));
        return result;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
