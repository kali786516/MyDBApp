import play.api.{Application, GlobalSettings}
import play.api.db.DB
import anorm._


object Global extends GlobalSettings {

  override def onStart(app: Application)={

    import play.api.Play.current

    DB.withConnection{ implicit connection =>
      SQL("create table if not exists contacts (id bigint not null auto_increment,name varchar(255),emailAddress varchar(255),primary key (id));").execute()
      SQL("INSERT INTO contacts(name,emailAddress) VALUES('Sri Tummala','kali.tummala@gmail.com')").execute()
      SQL("INSERT INTO contacts(name,emailAddress) VALUES('Manasa Tummala','mansa.tummala@gmail.com')").execute()
      SQL("INSERT INTO contacts(name,emailAddress) VALUES('Srinivas Ramisetty','srinivas.ramisetty@gmail.com')").execute()
    }

  }

}
