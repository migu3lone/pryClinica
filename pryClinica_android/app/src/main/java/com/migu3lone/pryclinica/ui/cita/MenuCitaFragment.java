package com.migu3lone.pryclinica.ui.cita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.migu3lone.pryclinica.R;
import com.migu3lone.pryclinica.ui.adapter.MenuCitaAdapter;

public class MenuCitaFragment extends Fragment {

    public MenuCitaFragment() {

    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menucita, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        MenuCitaAdapter adapter = new MenuCitaAdapter(getActivity());
        adapter.addFragment(new ViewCitaFragment(), "Lista");
        adapter.addFragment(new AddCitaFragment(), "Agregar");
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        }).attach();

        return view;
    }
}