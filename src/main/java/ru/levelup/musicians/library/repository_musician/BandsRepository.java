package ru.levelup.musicians.library.repository_musician;

import ru.levelup.musicians.library.modelmusician.Bands;

import java.util.List;

public interface BandsRepository {
   public Bands createBand(String band_title, String years_active, Integer country_id);
   public void deleteBandbyId(Integer band_id);
   public List<Bands> findBandByTitle(String band_title);
}

