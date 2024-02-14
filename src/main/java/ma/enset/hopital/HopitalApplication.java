package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.awt.geom.PathIterator;
import java.util.Date;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
/*       patientRepository.save(new Patient(null,"Mohamed",new Date(),false,4000));
       patientRepository.save(new Patient(null,"Hanane",new Date(),false,432));
       patientRepository.save(new Patient(null,"Imane",new Date(),true,340));
        patientRepository.save(new Patient(null,"Hassen",new Date(),false,6592));
        patientRepository.save(new Patient(null,"Houda",new Date(),true,120));
        patientRepository.save(new Patient(null,"Wided",new Date(),true,650));
        patientRepository.save(new Patient(null,"Mourad",new Date(),false,850));
        patientRepository.save(new Patient(null,"Adel",new Date(),false,360));
        patientRepository.save(new Patient(null,"Belgacem",new Date(),true,340));
        patientRepository.save(new Patient(null,"Zohra",new Date(),true,656));
        patientRepository.save(new Patient(null,"Kamel",new Date(),false,783));
        patientRepository.save(new Patient(null,"Ihsen",new Date(),true,498));*/
    }

    @Bean
    CommandLineRunner start (JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder pwdEncoder=passwordEncoder();
        return args -> {
            jdbcUserDetailsManager.createUser(User.withUsername("admin11")
                    .password(pwdEncoder.encode("456")).roles("USER","ADMIN").build());
            jdbcUserDetailsManager.createUser(User.withUsername("user11")
                    .password(pwdEncoder.encode("456")).roles("USER").build());
            jdbcUserDetailsManager.createUser(User.withUsername("user22")
                    .password(pwdEncoder.encode("456")).roles("USER").build());
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
