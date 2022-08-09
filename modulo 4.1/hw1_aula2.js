db.createCollection("postagem");

db.postagem.insertMany([
    {
        "idPostagem": 1,
        "descricao": "Gostei demais",
        "curtidas": "12",
        "data": new Date(2022, 1, 1),
        "usuario": {
            "id": 1,
            "nome": "Rafael",
            "tipo": "DEV"
        }
    },
    {
        "idPostagem": 2,
        "descricao": "Simplesmenmte genial",
        "curtidas": "127",
        "data": new Date(2020, 1, 1),
        "usuario": {
            "id": 2,
            "nome": "Gabriel",
            "tipo": "ADMIN"
        }
    },
    {
        "idPostagem": 3,
        "descricao": "Vou apagar.",
        "curtidas": "5000",
        "data": new Date(2022, 8, 4),
        "usuario": {
            "id": 2,
            "nome": "Gabriel",
            "tipo": "ADMIN"
        }
    }
]);

db.postagem.insertOne([
    {
        "idPostagem": 4,
        "descricao": "Achei interessante demais",
        "curtidas": "512",
        "data": new Date(2022, 4, 1),
        "usuario": {
            "id": 1,
            "nome": "Rafael",
            "tipo": "DEV"
        }
    }
])

db.postagem.updateOne(
    { "descricao": { $regex: /demais/ } },
    { $set: { "descricao": "Absurdo!!" } }
);

db.postagem.find({ idPostagem: 1 },
    {
        descricao: true,
        usuario: {
            nome: true,
            tipo:true
        },
        data: true
    }
)

db.postagem.find({
    data:{
        $gte:new Date(2022,1,1)
    }
})


db.postagem.deleteOne(
    { "descricao": { $regex: /vou/ } },
)

db.postagem.deleteMany({})
