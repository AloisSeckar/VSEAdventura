/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IItem;



/*******************************************************************************
 * Instance interfejsu {@code IItemG} přestavují objekty v místnostech.
 * Předměty mohou být jak věci, tak i osoby či jiné skutečnosti (vůně,
 * světlo, fluidum, ...).
 * <p>
 * Některé z předmětů mohou charakterizovat stav místnosti (např. je rozsvíceno),
 * jiné mohou být určeny k tomu, aby je hráč "zvednul" a získal tím nějakou
 * schopnost či možnost projít nějakým kritickým místem hry
 * (např. klíč k odemknutí dveří).
 * <p>
 * Rozhodnete-li se použít ve hře předměty, které budou obsahovat jiné předměty,
 * (truhla, stůl, ...), můžete je definovat paralelně jako zvláštní druh
 * místnosti, do které se "vstupuje" např. příkazem "prozkoumej truhlu"
 * a která se opouští např. příkazem "zavři truhlu".
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IItemG
         extends IItem
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí odkaz na obrázek daného předmětu.
     *
     * @return  Požadovaný odkaz
     */
//    @Override
    public String getPicture()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
