package ru.levelup.musicians.library.repository_musician.implmusician;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.levelup.musicians.library.modelmusician.Bands;
import ru.levelup.musicians.library.repository_musician.BandsRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernateBandsRepository implements BandsRepository {
private final SessionFactory factory;


    @Override
    public Bands createBand(String band_title, String years_active, Integer country_id) {
        try (Session session = factory.openSession()){
            Transaction tx = session.beginTransaction();
            Bands band = new Bands();
            band.setBand_title(band_title);
            band.setYears_active(years_active);
            band.setCountry_id(country_id);

            session.persist(band);
            System.out.println("new band: " + band.getBand_id());
            tx.commit();
            return band;

        }

    }

    @Override
    public void deleteBandbyId(Integer band_id) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            int result = session.createQuery("delete from Bands where band_id =: band_id")
                    .setParameter("band_id", band_id)
                    .executeUpdate();
            tx.commit();
            System.out.println("deleted rows: " + result);
        }

    }

    @Override
    public List<Bands> findBandByTitle(String band_title) {
        try(Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            tx.commit();
            List<Bands> bands = session.createQuery("from Bands where band_title like :band_title", Bands.class)//bands.class - what is it
                    .setParameter("band_title", band_title).getResultList();
            System.out.println("Result list: " + bands);
            return  bands;

        }
    }
}
