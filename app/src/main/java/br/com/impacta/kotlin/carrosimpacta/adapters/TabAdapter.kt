package br.com.impacta.kotlin.carrosimpacta.adapters

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.impacta.kotlin.carrosimpacta.enums.TipoCarro
import br.com.impacta.kotlin.carrosimpacta.fragments.CarrosFragment

class TabAdapter(private val context: Context,
                 fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        val tipo = getTipoCarro(position)
        val fragment = CarrosFragment()
        val arguments = Bundle()
        arguments.putSerializable("tipo", tipo)
        fragment.arguments = arguments
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val tipo  = getTipoCarro(position)
        return context.getString(tipo.value)
    }

    private fun getTipoCarro(position: Int) = when(position) {
        0 -> TipoCarro.CLASSICOS
        1 -> TipoCarro.ESPORTIVOS
        else -> TipoCarro.LUXO
    }
}