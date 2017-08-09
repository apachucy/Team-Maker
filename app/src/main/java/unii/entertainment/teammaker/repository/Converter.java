package unii.entertainment.teammaker.repository;


public interface Converter<model, persistence> {

    model convertToModel(persistence object);

    persistence convertToPersistence(model object);
}
